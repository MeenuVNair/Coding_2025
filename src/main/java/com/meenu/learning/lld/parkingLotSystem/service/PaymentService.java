package com.meenu.learning.lld.parkingLotSystem.service;


import com.meenu.learning.lld.parkingLotSystem.adapter.PaymentGatewayAdapter;
import com.meenu.learning.lld.parkingLotSystem.adapter.RazorPayAdapter;
import com.meenu.learning.lld.parkingLotSystem.domain.Payment;
import com.meenu.learning.lld.parkingLotSystem.repository.PaymentRepository;

import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class PaymentService {
    private PaymentRepository paymentRepository;
    private PaymentGatewayAdapter paymentGateway;

    public PaymentService(PaymentRepository paymentRepository, PaymentGatewayAdapter paymentGateway) {
        this.paymentRepository = paymentRepository;
        this.paymentGateway = paymentGateway;
    }

    public boolean processPayment(UUID ticketId, double amount) {
        System.out.println("[PaymentService] Processing payment for ticket: " + ticketId + " amount: " + amount);
        Payment payment = new Payment(ticketId, amount, paymentGateway);
        paymentRepository.save(payment);
        boolean success = paymentGateway.pay(ticketId, amount);
        if(success)
            payment.markAsSuccessful();
        else payment.markAsFailed();

        paymentRepository.update(payment);
        System.out.println("[PaymentService] Payment processed with status: " + (success ? "SUCCESS" : "FAILED"));
        return success;
    }

    public boolean processPaymentWithRetries(UUID ticketId, double amount, int maxRetries, PaymentGatewayAdapter gatewayForRetry) {
        System.out.println("[PaymentService] Processing payment with retry for ticket: " + ticketId);
        for(int i = 0; i < maxRetries; i++) {
            boolean success = processPayment(ticketId, amount);
            if(success) {
                System.out.println("[PaymentService] Payment successful on attempt " + i);
                return true;
            } else{
                // Try different gateway on retry
                this.paymentGateway = gatewayForRetry;
                System.out.println("[PaymentService] Switching gateway for retry");
            }
        }
        System.out.println("[PaymentService] Payment failed after " + maxRetries + " attempts");
        return false;
    }

    public PaymentGatewayAdapter getDefaultGateway() {
        return new RazorPayAdapter();
    }
}
