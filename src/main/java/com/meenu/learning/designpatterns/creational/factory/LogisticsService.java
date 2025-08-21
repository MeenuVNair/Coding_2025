package com.meenu.learning.designpatterns.creational.factory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

public class LogisticsService { // Class implementing the Logistics Services
    public void send(String mode) {
        Logistics logistics = LogisticsFactory.getLogistics(mode); // Using the Logistics Factory to get the desired object based on the mode
        logistics.send();
    }
}
