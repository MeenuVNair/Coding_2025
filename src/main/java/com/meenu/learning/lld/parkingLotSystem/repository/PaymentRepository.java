package com.meenu.learning.lld.parkingLotSystem.repository;


import com.meenu.learning.lld.parkingLotSystem.domain.Payment;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

public class PaymentRepository {
    private Map<UUID, Payment> payments = new HashMap<>();
    private Map<UUID, List<Payment>> ticketToPayments = new HashMap<>();

    public Payment save(Payment payment) {
        payments.put(payment.getPaymentId(), payment);
        ticketToPayments.putIfAbsent(payment.getTicketId(), new ArrayList<>());
        List<Payment> paymentList = ticketToPayments.get(payment.getTicketId());
        paymentList.add(payment);
        ticketToPayments.put(payment.getTicketId(), paymentList);
        return payment;
    }

    public Payment findById(UUID paymentId) {
        return payments.get(paymentId);
    }

    public List<Payment> findByTicketId(UUID ticketId) {
        return ticketToPayments.get(ticketId);
    }

    public void update(Payment payment) {
        if(payments.containsKey(payment.getPaymentId()))
            payments.put(payment.getPaymentId(), payment);
    }

    public void delete(UUID paymentId) {
        Payment payment = payments.remove(paymentId);
        if(Objects.nonNull(payment)) {
            List<Payment> paymentList = ticketToPayments.get(payment.getTicketId());
            if(Objects.nonNull(paymentList))
                paymentList.remove(payment);
        }
    }
}
