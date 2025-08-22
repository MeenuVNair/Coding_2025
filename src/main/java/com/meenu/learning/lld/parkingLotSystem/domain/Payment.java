package com.meenu.learning.lld.parkingLotSystem.domain;


import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class Payment {
    private UUID id;
    private UUID ticketId;
    private double amount;
    private PaymentGateway paymentGateway;
    private PaymentStatus paymentStatus;

    public enum PaymentGateway {
        RAZORPAY, STRIPE;
    }

    public enum PaymentStatus {
        SUCCESS, FAILED, PENDING
    }

    public Payment(UUID ticketId, double amount, PaymentGateway paymentGateway) {
        id = UUID.randomUUID();
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentGateway = paymentGateway;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentGateway getPaymentGateway() {
        return paymentGateway;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }
}
