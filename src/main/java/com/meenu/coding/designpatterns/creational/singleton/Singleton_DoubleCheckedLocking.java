package com.meenu.coding.designpatterns.creational.singleton;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 This is a more efficient way to achieve thread safety.
 The idea is to check if the instance is null before acquiring the lock.
 If it is, then we synchronize the block and check again.
 This reduces the overhead of synchronization after the instance has been created.

 - The outer if check avoids synchronization once the instance is created.
 - The inner if inside synchronized ensures that only one thread creates the instance.
 - volatile keyword ensures changes made by one thread are visible to others.
    Without volatile, one thread might create the Singleton instance, but other threads may not see the updated value due to caching.
    volatile ensures that the instance is always read from the main memory, so all threads see the most up-to-date version.

 Pros
 -----
 Efficient: Synchronization only happens once, when the instance is created.
 Safe and fast in concurrent environments.

 Cons
 ------
 Slightly more complex than the synchronized method.
 Requires Java 1.5 or above due to reliance on volatile.

 */

public class Singleton_DoubleCheckedLocking {
    private static volatile Singleton_DoubleCheckedLocking singletonObject; // Volatile object declaration

    private Singleton_DoubleCheckedLocking() {} // Private constructor

    public static Singleton_DoubleCheckedLocking getInstance() { // Thread-safe method using double-checked locking
        if(singletonObject == null) {
            synchronized (Singleton_DoubleCheckedLocking.class) {
                if(singletonObject == null) {
                    singletonObject = new Singleton_DoubleCheckedLocking();
                }
            }
        }
        return singletonObject;
    }
}
