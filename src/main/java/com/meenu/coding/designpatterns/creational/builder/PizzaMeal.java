package com.meenu.coding.designpatterns.creational.builder;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

import java.util.List;

/*******  APPROACH ********************

 */

public class PizzaMeal {
    //mandatory
    private final String crust;
    private final String type;

    //optional
    private final List<String> toppings;
    private final boolean isHandTossed;
    private final String crustType;
    private final String side;
    private final String drink;

    PizzaMeal(PizzaBuilder builder) {
        this.crust = builder.getCrust();
        this.type = builder.getType();
        this.toppings = builder.getToppings();
        this.isHandTossed = builder.isHandTossed();
        this.crustType = builder.getCrustType();
        this.side = builder.getSide();
        this.drink = builder.getDrink();
    }

    @Override
    public String toString() {
        return "PizzaMeal{" +
                "crust='" + crust + '\'' +
                ", type='" + type + '\'' +
                ", toppings=" + toppings +
                ", isHandTossed=" + isHandTossed +
                ", crustType='" + crustType + '\'' +
                ", side='" + side + '\'' +
                ", drink='" + drink + '\'' +
                '}';
    }
}
