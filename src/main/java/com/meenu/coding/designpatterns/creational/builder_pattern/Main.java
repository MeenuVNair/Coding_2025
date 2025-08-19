package com.meenu.coding.designpatterns.creational.builder_pattern;

import java.util.Arrays;

/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ********************
 Builder class can be kept as a separate file as well, but ideal practice is to keep it as an inner class

 Pros:
---------
 Keeps BurgerMeal and BurgerBuilder tightly coupled (logical, since the builder is only used to build BurgerMeal).
 Easier encapsulation: builder can directly access private fields of BurgerMeal without needing getters.
 Common convention: most Java developers expect a builder to be a static inner class.
 Cleaner namespace: avoids cluttering the package with an extra file.

 Cons:
---------
 The builder is not reusable outside BurgerMeal.
 If BurgerBuilder grows too large (lots of logic), the inner class might make BurgerMeal.java bloated.

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

public class Main {
    public static void main(String[] args) {
        BurgerMeal meal = new BurgerMeal.BurgerBuilder("wheat", "non-veg").build();
        BurgerMeal parcelMeal = new BurgerMeal.BurgerBuilder("maida", "non-veg")
                .withCheese(true)
                .withSide("fries")
                .withDrink("pepsi")
                .withToppings(Arrays.asList("bbq chicken", "sun dried tomatoes")).build();
        System.out.println(meal);
        System.out.println(parcelMeal);
    }
}
