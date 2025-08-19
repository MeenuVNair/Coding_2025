package com.meenu.coding.designpatterns.creational.builder_pattern;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

import java.util.Arrays;

/*******  APPROACH ********************
 Builder class can be kept as a separate file as well, but ideal practice is to keep it as an inner class
 Separate Builder Class (less common, but valid)

 Pros:
----------
 Cleaner separation of concerns: PizzaMeal only holds data/behavior, while PizzaBuilder is in charge of construction.
 Good if you plan to have multiple ways to construct BurgerMeal, e.g., different builders (PizzaJsonBuilder, PizzaFileBuilder).
 Easier to unit-test builder logic separately.

 Cons:
---------
 Slightly more boilerplate (need getters/setters or package-private access).
 More files in the package, which can clutter small projects.
 Less idiomatic – developers usually expect the builder to live inside the class it builds.


 Industry Practice
--------------------------
 ==> For domain models, immutable objects, DTOs → Inner static builder is preferred (more readable, less boilerplate).
 ==> For complex construction logic or multiple builders → Separate builder class is better.

 Real World Products Using Builder Pattern
 =============================================

 1. Lombok's @Builder Annotation (Java)
 Lombok is a Java library that reduces boilerplate code using annotations. One of its popular features is the @Builder annotation, which automatically generates a builder class behind the scenes.
 Instead of writing the builder logic manually, you just annotate your class:
 @Builder
 public class User {
 private String name;
 private int age;
 private String address;
 }

 Now, you can build objects using a fluent API:

 User user = User.builder()
 .name("John")
 .age(30)
 .address("NYC")
 .build();

 2. Amazon Cart Configuration
 Think about Amazon's shopping cart system. When you add an item to your cart, you're not just storing an item ID. You're building a complex object with fields like:
 - Quantity
 - Size or color (for apparel)
 - Delivery option
 - Gift wrap
 - Save for later status
 - Discounted price or offer tag

 Each user may customize these options differently.
 Internally, such cart items are likely created using a Builder Pattern to allow step-by-step configuration while ensuring data consistency and immutability.

 */

public class PizzaMain {
    public static void main(String[] args) {
        PizzaMeal meal = new PizzaBuilder("maida", "non-veg").build();
        PizzaMeal familyMeal = new PizzaBuilder("maida", "non-veg")
                                        .withDrink("cola")
                                        .withSide("choco lava cake")
                                        .withToppings(Arrays.asList("sun dried tomatoes"))
                                        .withCrustType("thin crust")
                                        .build();

        System.out.println(meal);
        System.out.println(familyMeal);
    }
}
