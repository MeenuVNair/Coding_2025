package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

/*******  APPROACH ******************** 
 The intuition of the algorithm is not to consider the subarray as a part of the answer if its sum is less than 0.
 A subarray with a sum less than 0 will always reduce our answer and so this type of subarray cannot be a part of the subarray with maximum sum.

 Here, we will iterate the given array with a single loop and while iterating we will add the elements in a sum variable.
 Now, if at any point the sum becomes less than 0, we will set the sum as 0 as we are not going to consider any subarray with a negative sum.
 Among all the sums calculated, we will consider the maximum one.
 */

/*******  BRUTE FORCE ******************** */
/*******  TIME LIMIT EXCEEDED ******************** */

/**
 Time Complexity:The time complexity is O(n^2) because of the nested for loops, where the outer loop iterates 'n' times and the inner loop iterates 'n-i' times.
 Space Complexity:The space complexity is O(1) because it uses a fixed number of variables regardless of the input size.
 */

/*public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        Integer max = Integer.MIN_VALUE;
        if(nums.length == 1) {
            return nums[0];
        }

        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}*/

/**
 Time Complexity:The time complexity is O(n) because the code iterates through the input array `nums` once.
 Space Complexity:The space complexity is O(1) because the code uses a constant amount of extra space regardless of the input size.

 * */

public class KadanesAlgorithm {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums) {
            sum += num;
            if(sum > maxSum)
                maxSum = sum;

            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.



 A subarray is a contiguous non-empty sequence of elements within an array.


 Examples:
 Input: nums = [2, 3, 5, -2, 7, -4]

 Output: 15

 Explanation: The subarray from index 0 to index 4 has the largest sum = 15

 Input: nums = [-2, -3, -7, -2, -10, -4]

 Output: -2

 Explanation: The element on index 0 or index 3 make up the largest sum when taken as a subarray

 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 */
