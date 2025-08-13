package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */

/*******  APPROACH ******************** 
 First we need to ensure our window has a sum greater than or equal to the target. We do this by expanding our window from the right.
 Once we have a window whose sum is greater than or equal to target, we need to minimize the size of our window
 We do this by shrinking our window from the left.
 We are doing this to find the minimum window length which will give us the sum >= target
 */

/**** COMPLEXITY ANALYSIS ******************** 
 TC : O(n)
 SC : O(1)

 Even though we have nested loops, the time complexity of this approach is  O(n).

 The inner loop won't necessarily run n times at every iteration.
 In fact, it may not run at all in some iterations. This is what is referred to as amortized analysis. The total number of iterations of the inner loop is n, same as the outer loop.

 Thus, both pointers move at most n times, making the time complexity O(n).
 */

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while(sum >= target) {
                sum -= nums[i];
                min = Math.min(min, j - i + 1);
                i++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



 Example 1:

 Input: target = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 Example 2:

 Input: target = 4, nums = [1,4,4]
 Output: 1
 Example 3:

 Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 Output: 0


 Constraints:

 1 <= target <= 109
 1 <= nums.length <= 105
 1 <= nums[i] <= 104


 Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
