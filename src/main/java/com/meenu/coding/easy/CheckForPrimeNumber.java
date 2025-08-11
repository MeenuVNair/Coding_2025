package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n) - The loop iterates up to n-2 times in the worst case.
 Space Complexity:O(1) - Constant space is used, regardless of the input n.
 */

public class CheckForPrimeNumber {
    public boolean isPrime(int n) {
        if(n < 2)
            return false;

        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer n. You need to check if the number is prime or not. Return true if it is a prime number, otherwise return false.



 A prime number is a number which has no divisors except 1 and itself.


 Examples:
 Input: n = 5

 Output: true

 Explanation: The only divisors of 5 are 1 and 5 , So the number 5 is prime.

 Input: n = 8

 Output: false

 Explanation: The divisors of 8 are 1, 2, 4, 8, thus it is not a prime number.

 Input: n = 9

 Output:
 true
 false
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= n <= 5000
 */
