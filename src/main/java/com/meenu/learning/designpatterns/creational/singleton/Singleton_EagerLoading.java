package com.meenu.learning.designpatterns.creational.singleton;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 In Eager Loading, the Singleton instance is created as soon as the class is loaded, regardless of whether it's ever used

 The object is created immediately when the class is loaded.
 It's always available and inherently thread-safe.

 Pros
 -----
 Very simple to implement.
 Thread-safe without any extra handling.

 Cons
 -------
 Wastes memory if the instance is never used.
 Not suitable for heavy objects.
 */


public class Singleton_EagerLoading {
    private static final Singleton_EagerLoading singletonObject = new Singleton_EagerLoading();

    private Singleton_EagerLoading() {} // private constructor, Declaring it private prevents creation of its object using the new keyword

    public static Singleton_EagerLoading getInstance() { // Method to get the instance of class
        return singletonObject; // Always returns the same instance
    }
}

