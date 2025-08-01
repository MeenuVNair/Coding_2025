package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

/*******  APPROACH ******************** 
 The following approach is motivated by Kandane’s algorithm
 Initially store 0th index value in prod1, prod2 and result.
 Traverse the array from 1st index.
 For each element, update prod1 and prod2.
 Prod1 is maximum of current element, product of current element and prod1, product of current element and prod2
 Prod2 is minimum of current element, product of current element and prod1, product of current element and prod2
 Return maximum of result and prod1
 */

/**
 Time Complexity:The time complexity is O(n) because the code iterates through the input array `nums` once.
 Space Complexity:The space complexity is O(1) because the code uses a fixed amount of extra space, regardless of the size of the input array.
 */

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int prod1 = nums[0], prod2 = nums[0], result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int temp = Math.max(nums[i], Math.max(prod1 * nums[i], prod2 * nums[i]));
            prod2 = Math.min(nums[i], Math.min(prod1 * nums[i], prod2 * nums[i]));
            prod1 = temp;

            result = Math.max(prod1, result);
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums. Find the subarray with the largest product, and return the product of the elements present in that subarray.



 A subarray is a contiguous non-empty sequence of elements within an array.


 Examples:
 Input: nums = [4, 5, 3, 7, 1, 2]

 Output: 840

 Explanation: The largest product is given by the whole array itself

 Input: nums = [-5, 0, -2]

 Output: 0

 Explanation: The largest product is achieved with the following subarrays [0], [-5, 0], [0, -2], [-5, 0, -2].

 Constraints:
 1 <= nums.length <= 104
 -10 <= nums[i] <= 10
 -109 <= product of any prefix or suffix of nums <= 109
 */
