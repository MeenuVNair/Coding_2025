package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 29/08/25
 */

/*******  APPROACH ******************** 
 Sum of the first \(n\) odd numbers: n^2
 Sum of the first \(n\) even numbers: n * (n + 1)

 We need to find GCD(n^2, n*(n+1))
 We can factor out \(n\) from both terms:
 GCD(n^2, n*(n+1)) = n*GCD(n, n+1)

 The greatest common divisor of two consecutive integers is always 1.
 This is because if a number divides both n and n+1, it must also divide their difference, which is n+1-n=1
 The only positive integer that divides 1 is 1.
 Therefore GCD(n, n+1) = 1

 Substituting this back into the expression for the GCD:
 GCD(n^2, n*(n+1)) = n*GCD(n, n+1)
                   = n * 1
                   = 1

 ==> The greatest common divisor of the sum of the first n odd numbers and the sum of the first n even numbers is n.

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(1)
 Space Complexity : O(1)
 */

public class GCDOfOddAndEvenSums {
    public int gcdOfOddEvenSums(int n) {
        return n;
    }
}

/*******  PROBLEM DESCRIPTION ********************

 You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:

 sumOdd: the sum of the first n odd numbers.

 sumEven: the sum of the first n even numbers.

 Return the GCD of sumOdd and sumEven.



 Example 1:

 Input: n = 4

 Output: 4

 Explanation:

 Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
 Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
 Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.

 Example 2:

 Input: n = 5

 Output: 5

 Explanation:

 Sum of the first 5 odd numbers sumOdd = 1 + 3 + 5 + 7 + 9 = 25
 Sum of the first 5 even numbers sumEven = 2 + 4 + 6 + 8 + 10 = 30
 Hence, GCD(sumOdd, sumEven) = GCD(25, 30) = 5.


 Constraints:

 1 <= n <= 1000

 Hint 1
 The first n odd numbers sum to n * n
 Hint 2
 First n even numbers sum to n * (n + 1)
 Hint 3
 gcd(n, n + 1) = 1, so the answer is n

 */
