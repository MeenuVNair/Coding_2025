package com.meenu.learning.designpatterns.creational.factory;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

public class LogisticsFactory { // Factory Class taking care of Logistics
    public static Logistics getLogistics(String mode) {
        if(mode.equalsIgnoreCase("road"))
            return new Road();
        if(mode.equalsIgnoreCase("air"))
            return new Air();
        throw new IllegalArgumentException("Invalid mode received : " + mode);
    }
}
