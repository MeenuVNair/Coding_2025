package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 Initialize three variables:
    count - to store the count of digits in the given number.
    sum - to store the sum of the digits of the number raised to the power of the number of digits.
    copy - to store the copy of the original number.
 Start iterating on the given number till there are digits left to extract. In each iteration, extract the last digit (using the modulus operator with 10), and add the digit raised to the power of count to sum. Update n by integer division with 10 effectively removing the last digit.
 After the iterations are over, check if the copy of the original is the same as the sum stored. If found equal, the original number is an Armstrong number, else it is not.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(d) where d is the number of digits in the input number n, due to the while loops in both isArmstrong and countDigits methods iterating based on the number of digits.
 Space Complexity:O(1) as it uses a constant amount of extra space for variables like count, num, sum, and lastDigit, regardless of the input size.
 */

public class CheckIfTheNumberIsArmstrong {
    public boolean isArmstrong(int n) {
        int count = countDigits(n);
        int num = n;
        int sum = 0;
        while(num > 0) {
            int lastDigit = num % 10;
            sum += Math.pow(lastDigit, count);
            num = num / 10;
        }
        return sum == n ? true : false;
    }

    private int countDigits(int digits) {
        int count = 0;
        while(digits > 0) {
            count++;
            digits = digits / 10;
        }
        return count;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.



 An armstrong number is a number which is equal to the sum of the digits of the number, raised to the power of the number of digits.


 Examples:
 Input: n = 153

 Output: true

 Explanation: Number of digits : 3.

 13 + 53 + 33 = 1 + 125 + 27 = 153.

 Therefore, it is an Armstrong number.

 Input: n = 12

 Output: false

 Explanation: Number of digits : 2.

 12 + 22 = 1 + 4 = 5.

 Therefore, it is not an Armstrong number.

 Input: n = 370

 Output:
 true
 false

 Submit
 Constraints:
 0 <= n <= 109
 */
