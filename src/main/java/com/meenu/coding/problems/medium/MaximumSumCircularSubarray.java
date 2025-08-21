package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 12/08/25
 */

/*******  APPROACH ******************** 
 1. Maximum subarray is non-circular – directly use normal Kadane’s algorithm.

 2. Maximum subarray is circular – which means we include both ends of the array.
 To get this, we subtract the minimum subarray sum from the total array sum.

 Step-by-step:

 - Let total be the sum of all elements in the array.
 - Let maxSum be the maximum subarray sum using Kadane’s algorithm (non-circular).
 - Let minSum be the minimum subarray sum (used to compute circular wrap-around max).

 Now:
 - Non-Circular Answer = maxSum
 - Circular Answer = total - minSum

 Final Answer:
 - If all elements are negative, circular logic fails (because total - minSum == 0),
    so return just maxSum.
 - Else, return Math.max(maxSum, total - minSum)

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n)
 Space complexity: O(1)
 */

public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currMax = 0;
        int minSum = Integer.MAX_VALUE;
        int currMin = 0;
        int total = 0;

        for(int num : nums) {
            total += num;
            currMax += num;
            if(currMax > maxSum) {
                maxSum = currMax;
            }
            if(currMax < 0) {
                currMax = 0;
            }

            currMin += num;
            if(currMin < minSum) {
                minSum = currMin;
            }
            if(currMin > 0) {
                currMin = 0;
            }
        }
        if(maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

 A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

 A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



 Example 1:

 Input: nums = [1,-2,3,-2]
 Output: 3
 Explanation: Subarray [3] has maximum sum 3.
 Example 2:

 Input: nums = [5,-3,5]
 Output: 10
 Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 Example 3:

 Input: nums = [-3,-2,-3]
 Output: -2
 Explanation: Subarray [-2] has maximum sum -2.


 Constraints:

 n == nums.length
 1 <= n <= 3 * 104
 -3 * 104 <= nums[i] <= 3 * 104

 Seen this question in a real interview before?
 1/5
 Yes
 No
 Accepted
 356,721/741.4K
 Acceptance Rate
 48.1%
 Topics
 icon
 Companies
 Hint 1
 For those of you who are familiar with the Kadane's algorithm, think in terms of that. For the newbies, Kadane's algorithm is used to finding the maximum sum subarray from a given array. This problem is a twist on that idea and it is advisable to read up on that algorithm first before starting this problem. Unless you already have a great algorithm brewing up in your mind in which case, go right ahead!
 Hint 2
 What is an alternate way of representing a circular array so that it appears to be a straight array? Essentially, there are two cases of this problem that we need to take care of. Let's look at the figure below to understand those two cases:

 Hint 3
 The first case can be handled by the good old Kadane's algorithm. However, is there a smarter way of going about handling the second case as well?
 */
