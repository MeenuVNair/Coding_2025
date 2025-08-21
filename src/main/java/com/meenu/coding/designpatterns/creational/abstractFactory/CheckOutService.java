package com.meenu.coding.designpatterns.creational.abstractFactory;



/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

public class CheckOutService {
    private String gatewayType;
    private PaymentGateway paymentGateway;
    private Invoice invoice;

    public CheckOutService(RegionFactory regionFactory, String gatewayType) {
        paymentGateway = regionFactory.createPaymentGateway(gatewayType);
        invoice = regionFactory.createInvoice();;
        this.gatewayType = gatewayType;
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}
