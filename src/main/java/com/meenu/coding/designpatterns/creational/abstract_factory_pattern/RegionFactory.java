package com.meenu.coding.designpatterns.creational.abstract_factory_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */


public interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}