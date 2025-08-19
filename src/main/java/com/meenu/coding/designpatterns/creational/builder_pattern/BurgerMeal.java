package com.meenu.coding.designpatterns.creational.builder_pattern;

import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ********************
 => Private Constructor
    The constructor of BurgerMeal is made private so that object creation is restricted to the Builder only.
 => Nested Static BurgerBuilder Class
    This builder class holds the same fields as BurgerMeal. It ensures immutability and keeps construction controlled.
 => Fluent API Style
    Each method (like withCheese, withSide) returns the builder itself, enabling method chaining in a fluent and readable manner.
 => Selective Configuration
    Only required fields (bunType, patty) are passed to the builder's constructor. Everything else is optional and set via withXYZ() methods.
 => Final Step: build()
    Once all desired fields are set, calling .build() finalizes the object construction and returns the BurgerMeal instance.
 */

public class BurgerMeal {
    //mandatory
    private final String bunType;
    private final String patty;

    //optional
    private final boolean hasCheese;
    private final String side;
    private final String drink;
    private final List<String> toppings;

    private BurgerMeal(BurgerBuilder builder) {
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.hasCheese = builder.hasCheese;
        this.side = builder.side;
        this.drink = builder.drink;
        this.toppings = builder.toppings;
    }

    @Override
    public String toString() {
        return "BurgerBuilder{" +
                "bunType='" + bunType + '\'' +
                ", patty='" + patty + '\'' +
                ", hasCheese=" + hasCheese +
                ", side='" + side + '\'' +
                ", drink='" + drink + '\'' +
                ", toppings=" + toppings +
                '}';
    }

    public static class BurgerBuilder {
        //mandatory
        private final String bunType;
        private final String patty;

        //optional
        private boolean hasCheese;
        private String side;
        private String drink;
        private List<String> toppings;

        // Builder constructor with required fields
        public BurgerBuilder(String bunType, String patty) {
            this.bunType = bunType;
            this.patty = patty;
        }

        // Methods to set optional fields

        public BurgerBuilder withCheese(boolean hasCheese) {
            this.hasCheese = hasCheese;
            return this;
        }

        public BurgerBuilder withSide(String side) {
            this.side = side;
            return this;
        }

        public BurgerBuilder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public BurgerBuilder withToppings(List<String> toppings) {
            this.toppings = toppings;
            return this;
        }

        public BurgerMeal build() {
            return new BurgerMeal(this);
        }
    }
}
