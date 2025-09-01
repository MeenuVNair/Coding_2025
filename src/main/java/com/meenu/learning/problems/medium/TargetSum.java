package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 01/09/25
 */

/*******  APPROACH ******************** 
 0/1 Knapsack
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(n * S)
 Space Complexity : O(n * S)
 n is the number of elements in the input array nums
 S is the total sum of the absolute values of the elements in nums
 */

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        int[][] memo = new int[n][2 * totalSum + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= 2 * totalSum; j++) {
                memo[i][j] = Integer.MIN_VALUE;
            }
        }
        return dfs(0, 0, totalSum, nums, target, memo);
    }

    private int dfs(int i, int currentSum, int totalSum, int[] nums, int target, int[][] memo) {
        if(i == nums.length)
            return currentSum == target ? 1 : 0;
        if(memo[i][currentSum + totalSum] != Integer.MIN_VALUE)
            return memo[i][currentSum + totalSum];

        memo[i][currentSum + totalSum] = dfs(i + 1, currentSum + nums[i], totalSum, nums, target, memo) +
                                         dfs(i + 1, currentSum - nums[i], totalSum, nums, target, memo);

        return memo[i][currentSum + totalSum];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer array nums and an integer target.

 You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

 For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 Return the number of different expressions that you can build, which evaluates to target.



 Example 1:

 Input: nums = [1,1,1,1,1], target = 3
 Output: 5
 Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 -1 + 1 + 1 + 1 + 1 = 3
 +1 - 1 + 1 + 1 + 1 = 3
 +1 + 1 - 1 + 1 + 1 = 3
 +1 + 1 + 1 - 1 + 1 = 3
 +1 + 1 + 1 + 1 - 1 = 3
 Example 2:

 Input: nums = [1], target = 1
 Output: 1


 Constraints:

 1 <= nums.length <= 20
 0 <= nums[i] <= 1000
 0 <= sum(nums[i]) <= 1000
 -1000 <= target <= 1000

 Recommended Time & Space Complexity
 You should aim for a solution as good or better than O(n * m) time and O(n * m) space, where n is the size of the input array and m is the sum of all the elements in the array.


 Hint 1
 Try to think in terms of recursion and visualize it as a decision tree, where we have two choices at each recursion step: assigning a positive or negative sign.


 Hint 2
 We recursively iterate through the array using index i, tracking the current sum along the recursive path. Each step branches into two paths, and we sum the number of ways to reach the target. If the index i goes out of bounds, we return 1 if the current sum equals the target; otherwise, we return 0.


 Hint 3
 This approach is exponential. We can use memoization to cache recursive call results and avoid redundant calculations. A hash map or a 2D array with modifications can be used for caching. If using a 2D array, the dimensions can be (n * (2m + 1)), where n is the array size and m represents the sum of the array elements.
 */
