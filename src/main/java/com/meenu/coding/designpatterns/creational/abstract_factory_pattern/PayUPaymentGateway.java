package com.meenu.coding.designpatterns.creational.abstract_factory_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class PayUPaymentGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing via PayU gateway, amount : " + amount);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
