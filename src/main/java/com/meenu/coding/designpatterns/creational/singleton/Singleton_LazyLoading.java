package com.meenu.coding.designpatterns.creational.singleton;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 In Lazy Loading, the Singleton instance is created only when it's needed — the first time the getInstance() method is called.

 The instance starts as null.
 It is only created when getInstance() is first called.
 Future calls return the already created instance.

 Pros
 -------
 Saves memory if the instance is never used.
 Object creation is deferred until required.

 Cons
 --------
 Lazy Loading is Not thread-safe by default. Thus, it requires synchronization in multi-threaded environments.
 */

public class Singleton_LazyLoading {
    private static Singleton_LazyLoading singletonObject; // Object declaration

    private Singleton_LazyLoading() {}  // private constructor. Declaring it private prevents creation of its object using the new keyword

    public static Singleton_LazyLoading getInstance() {  // Method to get the instance of class
        if(singletonObject == null) { // If the object is not created
            singletonObject = new Singleton_LazyLoading(); // A new object is created
        }
        return singletonObject; // Otherwise the already created object is returned
    }
}
