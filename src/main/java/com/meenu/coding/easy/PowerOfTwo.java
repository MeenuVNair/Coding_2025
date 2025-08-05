package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH 1 : Loop (Multiplication)  ********************
 Start from 1 and keep multiplying by 2 until we either:
 - Reach n → it's a power of two
 - Exceed n → it's not a power of two
 We use long to avoid overflow when n is close to Integer.MAX_VALUE.

 Start with i = 1
 While i < n, multiply i by 2
 If i == n at any point → return true, else return false
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(log n)
                Each iteration multiplies by 2, so it runs in log₂(n) time.
 Space complexity: O(1)
                Only one variable used.
 */

/*public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while(i < n) {
            i = i * 2;
        }
        return i == n;
    }
}*/


/*******  APPROACH 2 : Bit Manipulation  ********************
 A power of two in binary has exactly one 1 and all other bits as 0.

 Examples:
 1 → 0001
 2 → 0010
 4 → 0100
 8 → 1000

 Subtracting 1 from a power of two flips that single 1 to 0 and turns all bits to the right into 1s.

 e.g.
 8 (1000)
 7 (0111)
 → 8 & 7 = 0

 So:
 If n > 0 && (n & (n - 1)) == 0, then n is a power of two.


 Check if n is greater than 0 (negative numbers can't be powers of two)
 Check if n & (n - 1) == 0
 → This confirms only one bit is set.


 */

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(1)
                Only a few bitwise operations.
 Space complexity: O(1)
 */


public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
       return n > 0 && (n & (n - 1)) == 0;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer n, return true if it is a power of two. Otherwise, return false.

 An integer n is a power of two, if there exists an integer x such that n == 2x.

 Example 1:

 Input: n = 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: n = 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: n = 3
 Output: false


 Constraints:

 -231 <= n <= 231 - 1


 Follow up: Could you solve it without loops/recursion?
 */
