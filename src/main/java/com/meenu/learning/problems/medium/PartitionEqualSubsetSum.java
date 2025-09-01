package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 01/09/25
 */

/*******  APPROACH ******************** 
 0/1 Knapsack
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(n * target)
 Space Complexity : O(n * target)
 n is the number of elements in the input array nums
 sum is the total sum of all elements in the input array nums
 */

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;

        Boolean[][] memo = new Boolean[n][sum / 2 + 1];
        return dfs(0, nums, memo, sum / 2);
    }

    private boolean dfs(int i, int[] nums, Boolean[][] memo, int target) {
        if(i >= nums.length)
            return target == 0;
        if(target < 0)
            return false;
        if(memo[i][target] != null)
            return memo[i][target];

        memo[i][target] = dfs(i + 1, nums, memo, target) || dfs(i + 1, nums, memo, target - nums[i]);
        return memo[i][target];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.



 Example 1:

 Input: nums = [1,5,11,5]
 Output: true
 Explanation: The array can be partitioned as [1, 5, 5] and [11].
 Example 2:

 Input: nums = [1,2,3,5]
 Output: false
 Explanation: The array cannot be partitioned into equal sum subsets.


 Constraints:

 1 <= nums.length <= 200
 1 <= nums[i] <= 100


 Recommended Time & Space Complexity
 You should aim for a solution as good or better than O(n * t) time and O(n * t) space, where n is the size of the input array and t is half the sum of the array elements.


 Hint 1
 If the sum of the array elements is not even, we can immediately return false. Think in terms of recursion, where we try to build a subset with a sum equal to half of the total sum. If we find such a subset, the remaining elements will automatically form another subset with the same sum. The entire array can also be considered as one subset, with the other being empty. Can you visualize this as a decision tree to process the array recursively?


 Hint 2
 We recursively iterate through the array with index i. At each step, we decide whether to include the current element in the subset or not. Instead of forming the subset explicitly, can you think of a better approach? Maybe you only need to track the subset sum rather than generating the subset itself.


 Hint 3
 We can track the subset sum using a variable curSum. At each step, we make two recursive calls. If adding the current element does not exceed the target, we include it. If either path leads to a solution, we immediately return true. Can you determine the base case for this recursion? All elements in the array are positive.


 Hint 4
 If curSum equals half the sum of the array elements, we return true. If index i goes out of bounds, we return false. This solution is exponential, but we can use memoization to cache recursive call results and avoid redundant computations. We can use a hash map or a 2D array with dimensions n * t, where n is the size of the input array and t is half the sum of the input array elements.

 */
