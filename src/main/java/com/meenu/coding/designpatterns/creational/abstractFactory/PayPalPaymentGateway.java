package com.meenu.coding.designpatterns.creational.abstractFactory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */


public class PayPalPaymentGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing via PayPal, amount : " + amount);
    }
}