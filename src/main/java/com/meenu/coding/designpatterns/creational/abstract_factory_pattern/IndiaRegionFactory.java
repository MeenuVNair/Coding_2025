package com.meenu.coding.designpatterns.creational.abstract_factory_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

public class IndiaRegionFactory implements RegionFactory{

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if(gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorPayPaymentGateway();
        }
        if(gatewayType.equalsIgnoreCase("payu")) {
            return new PayUPaymentGateway();
        }
        throw new IllegalArgumentException("Unknown payment gateway : " + gatewayType);
    }

    @Override
    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}
