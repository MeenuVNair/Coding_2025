package com.meenu.coding.designpatterns.creational.abstract_factory_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */


public class GSTInvoice implements Invoice{
    @Override
    public void generateInvoice() {
        System.out.println("Generating GST Invoice");
    }
}

