package com.meenu.coding.designpatterns.creational.abstract_factory_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

public class USRegionFactory implements RegionFactory{

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if(gatewayType.equalsIgnoreCase("paypal"))
            return new PayPalPaymentGateway();
        if(gatewayType.equalsIgnoreCase("stripe"))
            return new StripePaymentGateway();
        throw new IllegalArgumentException("Unknown gateway type provided : " + gatewayType);
    }

    @Override
    public Invoice createInvoice() {
        return new USInvoice();
    }
}
