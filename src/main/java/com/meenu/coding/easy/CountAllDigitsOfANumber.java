package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 Initialise a counter to keep the count of digits in the number. Keep dividing the number by 10 until no more digits are left to extract.
 For every digit extracted from the number, increment the counter by 1.
 Once the iterations are over, the number of digits is stored in the counter.

 If the given number is zero,
 Return 1, because the number of digits in zero is 1.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:The time complexity is O(log n) because the while loop iterates a number of times proportional to the number of digits in n, which is logarithmic with respect to n.
 Space Complexity:The space complexity is O(1) because the algorithm uses a constant amount of extra space, regardless of the input n.
 */

public class CountAllDigitsOfANumber {
    public int countDigit(int n) {
        if(n == 0)
            return 1;
        int count = 0;
        while(n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer n. You need to return the number of digits in the number.



 The number will have no leading zeroes, except when the number is 0 itself.


 Examples:
 Input: n = 4

 Output: 1

 Explanation: There is only 1 digit in 4.

 Input: n = 14

 Output: 2

 Explanation: There are 2 digits in 14.

 Input: n = 234

 Output:
 9
 6
 2
 3
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 0 <= n <= 5000
 n will contain no leading zeroes except when it is 0 itself.
 */
