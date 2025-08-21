package com.meenu.coding.designpatterns.creational.abstractFactory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */


public interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}