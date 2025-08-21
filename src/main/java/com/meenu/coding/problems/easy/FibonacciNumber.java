package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(2^n) due to the recursive calls that branch into two calls for each n, resulting in an exponential growth of computations.
 Space Complexity:O(n) due to the depth of the recursion tree, which can go up to n in the worst-case scenario, requiring stack space for each function call.
 */

public class FibonacciNumber {
    public int fib(int n) {
        if(n < 2)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,



 F(0) = 0, F(1) = 1
 F(n) = F(n - 1) + F(n - 2), for n > 1.


 Given n, calculate F(n).


 Examples:
 Input : n = 2

 Output : 1

 Explanation : F(2) = F(1) + F(0) => 1 + 0 => 1.

 Input : n = 3

 Output : 2

 Explanation : F(3) = F(2) + F(1) => 1 + 1 => 2.

 Constraints:
 0 <= n <= 20
 */
