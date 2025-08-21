package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.Arrays;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) due to the single loop iterating up to n.
 Space Complexity:O(n) because the divisorArray can store up to n elements in the worst case, and Arrays.copyOf creates a new array of size index which can be up to n.
 */

public class DivisorsOfANumber {
    public int[] divisors(int n) {
        int[] divisorArray = new int[n];
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) {
                divisorArray[index++] = i;
            }
        }
        int[] result = Arrays.copyOf(divisorArray, index);
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.



 A number which completely divides another number is called it's divisor.


 Examples:
 Input: n = 6

 Output = [1, 2, 3, 6]

 Explanation: The divisors of 6 are 1, 2, 3, 6.

 Input: n = 8

 Output: [1, 2, 4, 8]

 Explanation: The divisors of 8 are 1, 2, 4, 8.

 Input: n = 7

 Output:
 [1]
 [7]
 [1, 7]
 [1, 2, 7]

 Submit
 Constraints:
 1 <= n <= 1000
 */
