package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class GCDOfTwoNumbers {
    public int GCD(int n1, int n2) {
        int gcd = 1;
        for(int i = 1; i <= Math.min(n1, n2); i++) {
            if((n1 % i) == 0 && (n2 % i) == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given two integers n1 and n2. You need find the Greatest Common Divisor (GCD) of the two given numbers. Return the GCD of the two numbers.



 The Greatest Common Divisor (GCD) of two integers is the largest positive integer that divides both of the integers.


 Examples:
 Input: n1 = 4, n2 = 6

 Output: 2

 Explanation: Divisors of n1 = 1, 2, 4, Divisors of n2 = 1, 2, 3, 6

 Greatest Common divisor = 2.

 Input: n1 = 9, n2 = 8

 Output: 1

 Explanation: Divisors of n1 = 1, 3, 9 Divisors of n2 = 1, 2, 4, 8.

 Greatest Common divisor = 1.

 Input: n1 = 6, n2 = 12

 Output:
 12
 6
 1
 9

 Submit
 Constraints:
 1 <= n1, n2 <= 1000
 */
