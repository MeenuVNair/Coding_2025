package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 16/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(n2)
 Space Complexity : O(1)
 */

/******** BRUTE FORCE - Time Limit Exceeded   *************/

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int totalSum = 0;
        int mod = (int)1e9 + 7; // Mod value
        for(int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for(int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                totalSum =  (totalSum + min) % mod;
            }
        }
        return totalSum;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.



 Example 1:

 Input: arr = [3,1,2,4]
 Output: 17
 Explanation:
 Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
 Sum is 17.
 Example 2:

 Input: arr = [11,81,94,43,3]
 Output: 444


 Constraints:

 1 <= arr.length <= 3 * 104
 1 <= arr[i] <= 3 * 104
 */
