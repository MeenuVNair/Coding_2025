package com.meenu.learning.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

// Client Class:
// Uses PaymentGateway interface to process payments
public class CheckoutService {
    private PaymentGateway paymentGateway;

    // Constructor injection for dependency inversion
    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    // Business logic to perform checkout
    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}