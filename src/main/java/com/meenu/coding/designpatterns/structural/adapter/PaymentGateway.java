package com.meenu.coding.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

// Target Interface:
// Standard interface expected by the CheckoutService
public interface PaymentGateway {
    void pay(String orderId, double amount);
}
