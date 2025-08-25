package com.meenu.learning.lld.parkingLotSystem.controller;


import com.meenu.learning.lld.parkingLotSystem.domain.Receipt;
import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;
import com.meenu.learning.lld.parkingLotSystem.domain.Vehicle;
import com.meenu.learning.lld.parkingLotSystem.service.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class ExitController {
    private TicketService ticketService;
    private SlotService slotService;
    private PaymentService paymentService;
    private ReceiptService receiptService;
    private PricingService pricingService;

    public ExitController(TicketService ticketService, SlotService slotService, PaymentService paymentService, ReceiptService receiptService, PricingService pricingService) {
        this.ticketService = ticketService;
        this.slotService = slotService;
        this.paymentService = paymentService;
        this.receiptService = receiptService;
        this.pricingService = pricingService;
    }

    public ExitResult vehicleExit(UUID ticketId) {
        System.out.println("[EXIT CONTROLLER] : Vehicle exit request");
        try {
            //fetch ticket
            Ticket ticket = ticketService.getTicket(ticketId);
            if (Objects.isNull(ticket)) { // ticket not found
                return new ExitResult(false, null, 0.0, "Ticket Not found");
            }
            if (!ticket.isActive())
                return new ExitResult(false, null, 0.0, "Ticket is not active");

            // calculate fee
            double totalAmount = pricingService.calculateFee(ticket);
            System.out.println("[ExitController] Fee calculated: " + totalAmount);

            // proceed to payment
            boolean success = paymentService.processPaymentWithRetries(ticketId, totalAmount, 3, paymentService.getDefaultGateway());
            if (!success) {
                return new ExitResult(false, null, totalAmount, "Payment failed");
            }

            // Generate receipt
            Receipt receipt = receiptService.generateReceipt(ticket, totalAmount);
            receiptService.markReceiptAsPaid(receipt);

            // Release slot
            slotService.releaseSlot(ticket.getSlotId());

            // Deactivate ticket
            ticketService.deactivateTicket(ticketId);

            System.out.println("[ExitController] Vehicle exit successful - Receipt: " + receipt.getReceiptId());
            return new ExitResult(true, receipt.getReceiptId(), totalAmount, "Exit successful");

        } catch (Exception e ) {
            System.out.println("[ExitController] Vehicle exit failed: " + e.getMessage());
            return new ExitResult(false, null, 0.0, e.getMessage());
        }
    }

    public String generateReceiptText(UUID ticketId) {
        System.out.println("[ExitController] Generating receipt text for ticket: " + ticketId);

        try {
            Ticket ticket = ticketService.getTicket(ticketId);
            if (Objects.isNull(ticket)) {
                return "Ticket not found";
            }

            double fee = pricingService.calculateFee(ticket);
            Receipt receipt = receiptService.generateReceipt(ticket, fee);

            String receiptText = receiptService.generateReceiptText(receipt, ticket);
            System.out.println("[ExitController] Receipt text generated successfully");
            return receiptText;

        } catch (Exception e) {
            System.out.println("[ExitController] Receipt text generation failed: " + e.getMessage());
            return "Error generating receipt: " + e.getMessage();
        }
    }

    public static class ExitResult {
        private final boolean success;
        private final UUID receiptId;
        private final double fee;
        private final String message;

        public ExitResult(boolean success, UUID receiptId, double fee, String message) {
            this.success = success;
            this.receiptId = receiptId;
            this.fee = fee;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public UUID getReceiptId() {
            return receiptId;
        }

        public double getFee() {
            return fee;
        }

        public String getMessage() {
            return message;
        }
    }
}
