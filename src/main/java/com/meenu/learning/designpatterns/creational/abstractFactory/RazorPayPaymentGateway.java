package com.meenu.learning.designpatterns.creational.abstractFactory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

public class RazorPayPaymentGateway implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing via RazorPay, amount : " + amount);
    }
}
