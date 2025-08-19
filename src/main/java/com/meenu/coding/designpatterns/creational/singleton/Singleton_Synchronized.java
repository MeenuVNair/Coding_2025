package com.meenu.coding.designpatterns.creational.singleton;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 This is the simplest way to ensure thread safety. By synchronizing the method that creates the instance, we can prevent multiple threads from creating separate instances at the same time.
 However, this approach can lead to performance issues due to the overhead of synchronization.

 The synchronized keyword ensures that only one thread at a time can execute the getInstance() method.
 This prevents multiple threads from entering the method simultaneously and creating multiple instances.

 Pros
 ------
 Simple and easy to implement.
 Thread-safe without needing complex logic.

 Cons
 -----
 Performance overhead: Every call to getInstance() is synchronized, even after the instance is created.
 May slow down the application in high-concurrency scenarios.

 */

public class Singleton_Synchronized {
    private static Singleton_Synchronized singletonObject; // Object declaration

    private Singleton_Synchronized() {} // Private constructor

    public static synchronized Singleton_Synchronized getInstance() { // Synchronized keyword used
        if(singletonObject == null) {
            singletonObject = new Singleton_Synchronized();
        }
        return singletonObject;
    }
}
