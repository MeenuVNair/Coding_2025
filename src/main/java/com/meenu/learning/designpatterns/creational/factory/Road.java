package com.meenu.learning.designpatterns.creational.factory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class Road implements Logistics{ // Class implementing the Logistics Interface
    @Override
    public void send() {
        System.out.println("Sending via Road");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
