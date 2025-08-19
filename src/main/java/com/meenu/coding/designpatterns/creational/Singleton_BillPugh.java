package com.meenu.coding.designpatterns.creational;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 This is a highly efficient way to implement the Singleton pattern.
 It uses a static inner helper class to hold the Singleton instance.
 The instance is created only when the inner class is loaded, which happens only when getInstance() is called for the first time.

 The Singleton instance is not created until getInstance() is called.
 The static inner class (Holder) is not loaded until referenced, thanks to Java's class loading mechanism.
 It ensures thread safety, lazy loading, and high performance without synchronization overhead.

 Pros
 ------
 Best of both worlds: Lazy + Thread-safe.
 No need for synchronized or volatile.
 Clean and efficient.

 Cons
 ------
 It is slightly less intuitive for beginners due to the use of a nested static class.

 */

public class Singleton_BillPugh {

    private Singleton_BillPugh() {}  // Private constructor

    private static class Holder { // Static inner class to hold the Singleton instance
        private static final Singleton_BillPugh instance = new Singleton_BillPugh();
    }

    public static Singleton_BillPugh getInstance() { // Public method to return the Singleton instance
        return Holder.instance;
    }
}
