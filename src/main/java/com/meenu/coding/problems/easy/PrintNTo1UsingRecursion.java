package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 first print, then call recursion -> to get in descending order

 calling recursion and then printing will result in ascending order
 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class PrintNTo1UsingRecursion {
    public void printNumbers(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printNumbers(n - 1);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer n, write a function to print all numbers from n to 1 (inclusive) using recursion.

 You must not use any loops such as for, while, or do-while.
 The function should print each number on a separate line, in decreasing order from n to 1

 Examples:
 Input: 5

 Output:

 5

 4

 3

 2

 1

 Input: 1

 Output:

 1

 Constraints:
 1 <= n <= 100

 Hint 1
 Your base case should occur when n equals 1. At this point, simply print 1 and stop the recursion. This prevents the function from calling itself indefinitely.

 Hint 2
 To ensure the numbers print in decreasing order from n to 1, you can first print n and then recursively call the function with n-1. This will print n, then n-1, then n-2, and so on, down to 1.
 */
