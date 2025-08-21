package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 
 To check if an integer is a palindrome, we reverse its digits and compare it with the original.
 If they’re equal, it’s a palindrome.
 Negative numbers are never palindromes because of the minus sign.

 Edge case: If x < 0, return false.
 Store the original number for later comparison.
 Reverse the number:
 Extract the last digit using % 10.
 Build the reversed number by shifting left (multiply by 10) and adding the digit.
 Drop the last digit from x using /= 10.
 Compare the reversed number with the original.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(log(n)) Because we process each digit once — number of digits is proportional to log of the number
 Space Complexity:O(1) Only a few variables used — constant space.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int n) {
        if(n < 0)
            return false;

        int reversedNumber = 0;
        int originalNumber = n;

        while(n != 0) {
            int remainder = n % 10; // Get the last digit
            reversedNumber = reversedNumber * 10 + remainder; // Build the reversed number
            n /= 10; // Remove the last digit from originalNumber
        }
        return reversedNumber == originalNumber;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 ou are given an integer n. You need to check whether the number is a palindrome number or not. Return true if it's a palindrome number, otherwise return false.



 A palindrome number is a number which reads the same both left to right and right to left.


 Examples:
 Input: n = 121

 Output: true

 Explanation: When read from left to right : 121.

 When read from right to left : 121.

 Input: n = 123

 Output: false

 Explanation: When read from left to right : 123.

 When read from right to left : 321.

 Input: 101

 Output:
 true
 false
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 0 <= n <= 5000
 n will contain no leading zeroes except when it is 0 itself.
 */
