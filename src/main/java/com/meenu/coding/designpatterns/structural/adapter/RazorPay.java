package com.meenu.coding.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

public class RazorPay {
    public void makePayment(String orderId, double amount) {
        System.out.println("Paid Rs. " + amount + " using RazorPay for orderId : " + orderId);
    }
}
