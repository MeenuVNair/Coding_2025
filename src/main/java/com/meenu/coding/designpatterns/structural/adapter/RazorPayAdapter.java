package com.meenu.coding.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class RazorPayAdapter implements PaymentGateway {
    private RazorPay razorPay;

    public RazorPayAdapter() {
        this.razorPay = new RazorPay();
    }

    @Override
    public void pay(String orderId, double amount) {
        razorPay.makePayment(orderId, amount);
    }
}