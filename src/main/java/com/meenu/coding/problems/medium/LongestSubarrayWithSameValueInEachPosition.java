package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */

/*******  APPROACH ******************** 
 We need to find the longest subarray so we should try to maximize our window while it is valid.

 We can start at the beginning and keep expanding our window from the right.
 Once we encounter a new value, we stop expanding our window.
 We then shrink our window by bringing our L pointer to our R pointer. We don't need to increment L because if we encountered a new value, it must be the case that every value before was a duplicate.
 We then repeatedly calculate the length of our window by taking the maximum of the current length and the maximum length.
 The length can be calculated by taking the difference between R and L and adding 1.
 */

/**** COMPLEXITY ANALYSIS ********************

 */

public class LongestSubarrayWithSameValueInEachPosition {
    public int longestSubarray(int[] nums) {
        int i = 0;
        int longest = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[i] != nums[j]) {
                i = j;
            }
            longest = Math.max(longest, j - i + 1);
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSameValueInEachPosition obj = new LongestSubarrayWithSameValueInEachPosition();
        int[] input = new int[]{4,2,2,3,3,3};
        int result = obj.longestSubarray(input);
        System.out.println(result == 3 ? "Passed" : "Test case failed\n Expected : 3, Your output : "+ result);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 Find the size of longest subarray with repeating characters
 Input : [4 2 2 3 3 3]
 Output : 3
 [3 3 3] is the longest subarray with same characters and its length is 3
 [2 2] and [4] are also subarrays with same character at each position but their length is 2 and 1 respectively.
 We need to return the longest subarray, hence 3 is the output here
 */
