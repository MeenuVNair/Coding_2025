package com.meenu.learning.designpatterns.structural.adapter;


/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

/**
 The Adapter Pattern allows incompatible interfaces to work together by acting as a translator or wrapper around an existing class.
 It converts the interface of a class into another interface that a client expects.

 It acts as a bridge between the Target interface (expected by the client) and the Adaptee (an existing class with a different interface).
 This structural wrapping enables integration and compatibility across diverse systems.

 Real-Life Analogy
 Imagine traveling from India to Europe.
 Your mobile charger doesn't fit into European sockets. Instead of buying a new charger, you use a plug adapter.
 The adapter allows your charger (with its Indian plug) to fit the European socket, enabling charging without modifying either the socket or the charger.

 Pros:
 --------
 Code Reusability: Encourages the reuse of existing classes without changing their implementation.
 Code Extensibility: Makes systems more flexible and adaptable to change.
 Minimal Changes to Client Code: Enables integration without requiring modifications to existing client logic.
 Simplifies Third-party Integration: Makes it easier to incorporate external services and APIs.

 Cons:
 --------
 Adds an Extra Layer of Abstraction: Can introduce unnecessary complexity if not used judiciously.
 Overuse Can Obscure System Design: Excessive use of adapters might make the architecture harder to understand and maintain.

 ==> Refer StructuralPattern-Notes (in structural folder) for Real Product Use Cases

 */

public class Main {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService(new PayUGateway());
        checkoutService.checkout("123", 3453.12);

        /* If we want to use RazorPay as the payment method,
        then we will use the RazorPayAdapter which is like a wrapper for RazorPay (as original RazorPay does not support pay() method used inside checkout() method)
        */
        CheckoutService checkoutService2 = new CheckoutService(new RazorPayAdapter());
        checkoutService2.checkout("242123", 8764.63);
    }
}
