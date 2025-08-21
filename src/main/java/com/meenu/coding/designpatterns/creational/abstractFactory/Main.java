package com.meenu.coding.designpatterns.creational.abstractFactory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ********************
 The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.

 In simpler terms:
 You use it when you have multiple factories, each responsible for producing objects that are meant to work together.

 When Should You Use It?
    - Use of the Abstract Factory Pattern is appropriate in the following scenarios:
    - When multiple related objects must be created as part of a cohesive set (e.g., a payment gateway and its corresponding invoice generator).
    - When the type of objects to be instantiated depends on a specific context, such as country, theme, or platform.
    - When client code should remain independent of concrete product classes.
    - When consistency across a family of related products must be maintained (e.g., a US payment gateway paired with a US-style invoice).
 */

public class Main {
    public static void main(String[] args) {
        CheckOutService service1 = new CheckOutService(new IndiaRegionFactory(), "razorpay");
        service1.completeOrder(123.35);
        CheckOutService service2 = new CheckOutService(new USRegionFactory(), "stripe");
        service2.completeOrder(7623.77);
    }
}
