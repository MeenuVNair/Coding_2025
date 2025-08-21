package com.meenu.coding.designpatterns.creational.builder;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

import java.util.List;

/*******  APPROACH ********************

 */

public class PizzaBuilder {
    //mandatory
    private final String crust;
    private final String type;

    //optional
    private List<String> toppings;
    private boolean isHandTossed;
    private String crustType;
    private String side;
    private String drink;

    public PizzaBuilder(String crust, String type) {
        this.crust = crust;
        this.type = type;
    }

    public PizzaBuilder withToppings(List<String> toppings) {
        this.toppings = toppings;
        return this;
    }

    public PizzaBuilder isHandTossed(boolean isHandTossed) {
        this.isHandTossed = isHandTossed;
        return this;
    }
    public PizzaBuilder withCrustType(String crustType) {
        this.crustType = crustType;
        return this;
    }
    public PizzaBuilder withSide(String side) {
        this.side = side;
        return this;
    }
    public PizzaBuilder withDrink(String drink) {
        this.drink = drink;
        return this;
    }

    public PizzaMeal build() {
        return new PizzaMeal(this);
    }

    //Getters for all fields as now Builder is moved out of the main class
    public String getCrust() {
        return this.crust;
    }

    public String getType() {
        return type;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public boolean isHandTossed() {
        return isHandTossed;
    }

    public String getCrustType() {
        return crustType;
    }

    public String getSide() {
        return side;
    }

    public String getDrink() {
        return drink;
    }
}
