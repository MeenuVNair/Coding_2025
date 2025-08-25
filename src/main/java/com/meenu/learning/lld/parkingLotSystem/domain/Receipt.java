package com.meenu.learning.lld.parkingLotSystem.domain;


import java.time.LocalDateTime;
import java.util.UUID;

/**
* @author Meenu V. Nair
* @created 25/08/25
*/

public class Receipt {
    private UUID receiptId;
    private UUID ticketId;
    private LocalDateTime exitTime;
    private double totalAmount;
    private Payment.PaymentStatus paymentStatus;

    public Receipt(double totalAmount, UUID ticketId) {
        this.receiptId = UUID.randomUUID();
        this.totalAmount = totalAmount;
        this.ticketId = ticketId;
        this.exitTime = LocalDateTime.now();
        this.paymentStatus = Payment.PaymentStatus.PENDING;
    }

    public void markAsSuccessful() {
        this.paymentStatus = Payment.PaymentStatus.SUCCESS;
    }

    public void markAsFailed() {
        this.paymentStatus = Payment.PaymentStatus.FAILED;
    }

    //getters

    public UUID getReceiptId() {
        return receiptId;
    }

    public UUID getTicketId() {
        return ticketId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Payment.PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", ticketId=" + ticketId +
                ", exitTime=" + exitTime +
                ", totalAmount=" + totalAmount +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
