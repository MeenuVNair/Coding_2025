package com.meenu.learning.lld.parkingLotSystem.adapter;


import java.util.Random;
import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class StripeAdapter implements PaymentGatewayAdapter{

    @Override
    public boolean pay(UUID ticketId, double amount) {
        // Simulate payment processing
        System.out.println("[StripeAdapter] Processing payment for ticket: " + ticketId + " amount: " + amount);

        // Simulate 95% success rate
        Random random = new Random();
        boolean success = random.nextDouble() < 0.95;

        System.out.println("[StripeAdapter] Payment result: " + (success ? "SUCCESS" : "FAILED"));

        return success;
    }

}
