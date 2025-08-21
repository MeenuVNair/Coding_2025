package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

/*******  APPROACH ******************** 
 Define a helper function that handles the recursive calculation of the power.
 Base case: If the exponent n is 0, return 1. This is because any number raised to the power of 0 is 1.
 Base case: If the exponent n is 1, return the base x. This is because any number raised to the power of 1 is itself.
 Check if the exponent n is even:
 If true, recursively calculate the power by squaring the base and halving the exponent.
 Example: power(x, n) = power(x * x, n / 2)
 Check if the exponent n is odd:
 If true, recursively calculate the power by multiplying the base with the result of the power function for n - 1.
 Example: power(x, n) = x * power(x, n - 1)
 Handle negative exponents by calculating the power for the positive exponent and taking the reciprocal.
 Combine these steps in a main function that checks if the exponent is negative and calls the helper function accordingly.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:The time complexity is O(n) due to the recursive calls in the power function, where n represents the exponent.
 Space Complexity:The space complexity is O(n) due to the recursive call stack of the power function.
 */

public class Pow {
    public double myPow(double x, int n) {
        long N = n;
        if(N < 0) {
            return 1.0 / power(x, -N);
        }
        return power(x, N);
    }

    public double power(double x, long n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }

        if(n % 2 == 1) {
            return x * power(x, n - 1);
        }
        return power(x * x, n / 2);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 mplement pow(x, n), which calculates x raised to the power n (i.e., xn).



 Example 1:

 Input: x = 2.00000, n = 10
 Output: 1024.00000
 Example 2:

 Input: x = 2.10000, n = 3
 Output: 9.26100
 Example 3:

 Input: x = 2.00000, n = -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25


 Constraints:

 -100.0 < x < 100.0
 -231 <= n <= 231-1
 n is an integer.
 Either x is not zero or n > 0.
 -104 <= xn <= 104
 */
