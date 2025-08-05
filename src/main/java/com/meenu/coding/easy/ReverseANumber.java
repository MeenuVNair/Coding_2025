package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 
 To reverse an integer, we repeatedly extract its last digit and build the reversed number.
 However, we must be cautious about integer overflow, since the reversed number can exceed Integer.MAX_VALUE.

 1. Take the absolute value of the input number x.
 2. Loop until the number becomes 0:
    - Get the last digit using % 10.
    - Check for overflow before multiplying and adding.
        Use: reversed > (Integer.MAX_VALUE - digit) / 10
    - Append the digit to the reversed number.
 3. Restore the original sign if needed.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity: O(log n) because the number of iterations depends on the number of digits in the input number n, which is logarithmic with respect to n.
 Space Complexity: O(1) because the algorithm uses a constant amount of extra space regardless of the input size.
 */

public class ReverseANumber {
    public int reverseNumber(int n) {
        int reversedNumber = 0;

        while(n != 0) {
            int remainder = n % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            n = n / 10;
        }

        return reversedNumber;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer n. Return the integer formed by placing the digits of n in reverse order.


 Examples:
 Input: n = 25

 Output: 52

 Explanation: Reverse of 25 is 52.

 Input: n = 123

 Output: 321

 Explanation: Reverse of 123 is 321.

 Input: n = 54

 Output:
 45
 54
 44
 2
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 0 <= n <= 5000
 n will contain no leading zeroes except when it is 0 itself.
 */
