package com.meenu.learning.lld.parkingLotSystem.adapter;


import java.util.UUID;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public interface PaymentGatewayAdapter {
    boolean pay(UUID ticketId, double amount);
}
