package com.meenu.learning.lld.parkingLotSystem.domain;


import com.meenu.learning.lld.parkingLotSystem.adapter.PaymentGatewayAdapter;

import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class Payment {
    private UUID paymentId;
    private UUID ticketId;
    private double amount;
    private PaymentGatewayAdapter paymentGateway;
    private PaymentStatus paymentStatus;

    public enum PaymentStatus {
        PENDING, SUCCESS, FAILED
    }


    public Payment(UUID ticketId, double amount, PaymentGatewayAdapter paymentGateway) {
        this.paymentId = UUID.randomUUID();
        this.ticketId = ticketId;
        this.amount = amount;
        this.paymentGateway = paymentGateway;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void markAsSuccessful() {
        this.paymentStatus = Payment.PaymentStatus.SUCCESS;
    }

    public void markAsFailed() {
        this.paymentStatus = Payment.PaymentStatus.FAILED;
    }

    //getters

    public UUID getPaymentId() {
        return paymentId;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentGatewayAdapter getPaymentGateway() {
        return paymentGateway;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", ticketId=" + ticketId +
                ", amount=" + amount +
                ", paymentGateway=" + paymentGateway +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
