package com.meenu.learning.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class PayUGateway implements PaymentGateway {

    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paid Rs. " + amount + " using PayU for orderId : " + orderId);
    }
}
