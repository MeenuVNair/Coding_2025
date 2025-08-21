package com.meenu.learning.designpatterns.creational.factory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 The object creation logic is moved to the LogisticsFactory.
 The LogisticsService class only focuses on business logic.
 Adding a new mode (e.g., Ship) only requires modifying the factory, not the service.

 */

public class Main { // Driver Code
    public static void main(String[] args) {
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("air");
        logisticsService.send("rail");
    }
}
