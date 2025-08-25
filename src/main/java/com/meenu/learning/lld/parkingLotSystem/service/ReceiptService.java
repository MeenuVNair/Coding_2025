package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.domain.Receipt;
import com.meenu.learning.lld.parkingLotSystem.domain.Ticket;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class ReceiptService {

    public ReceiptService() {
        System.out.println("[ReceiptService] ReceiptService initialized");
    }

    public Receipt generateReceipt(Ticket ticket, double amount) {
        System.out.println("[ReceiptService] Generating receipt for ticket: " + ticket.getTicketId());
        Receipt receipt = new Receipt(amount, ticket.getTicketId());
        System.out.println("[ReceiptService] Receipt generated: " + receipt.getReceiptId() + " with fee: " + amount);
        return receipt;
    }

    public void markReceiptAsPaid(Receipt receipt) {
        System.out.println("[ReceiptService] Marking receipt as paid: " + receipt.getReceiptId());
        receipt.markAsSuccessful();
        System.out.println("[ReceiptService] Receipt marked as paid successfully");
    }

    public String generateReceiptText(Receipt receipt, Ticket ticket) {
        System.out.println("[ReceiptService] Generating receipt text for: " + receipt.getReceiptId());
        StringBuilder receiptText = new StringBuilder();
        receiptText.append("📄 Receipt:\n");
        receiptText.append("=== PARKING RECEIPT ===\n");
        receiptText.append("Receipt ID: ").append(receipt.getReceiptId()).append("\n");
        receiptText.append("Ticket ID: ").append(ticket.getTicketId()).append("\n");
        receiptText.append("Vehicle: DUMMY-").append(ticket.getTicketId()).append(" (CAR)\n");
        receiptText.append("Entry Time: ").append(ticket.getEntryTime()).append("\n");
        receiptText.append("Exit Time: ").append(receipt.getExitTime()).append("\n");
        receiptText.append("Total Fee: $").append(String.format("%.2f", receipt.getTotalAmount())).append("\n");
        receiptText.append("Payment Status: ").append(receipt.getPaymentStatus()).append("\n");
        receiptText.append("=====================\n");

        System.out.println("[SERVICE] Receipt text generated successfully");
        return receiptText.toString();
    }
}
