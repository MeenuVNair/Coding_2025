package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 16/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n⋅(n+k))
     The outer loop for x is O(n)
     The uncapping loop is O(k), just to check intermediate sums.
     The capped check loop is O(n), since it's varied O(n−i) over time.

 Space complexity: O(n+k)
    The boolean arrays sized n and k+1.
 */

public class SubsequenceSumAfterCappingElements {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;

        // Sort ascendingly, as we explore the x ascendingly
        Arrays.sort(nums);
        boolean[] ans = new boolean[n];

        // Max value we care about is k
        boolean[] dp = new boolean[k+1];
        dp[0] = true;

        // Each elements <= n will be uncapped once.
        int i = 0;

        for(int x=1; x<=n; x++) {
            // Expand the uncapped
            for(; i < n && nums[i] < x; i++) {
                for(int j=k; j>=nums[i]; j--)
                    dp[j] = dp[j] || dp[j - nums[i]];
            }

            // Since the bigger elements are capped
            // We can just pick how many times it will be added
            // 0x, x, 2x, 3x, ... , (n - i)x
            int nCapped = n - i;
            for(int j=0; j<=nCapped; j++) {
                int times = j * x;
                if(times > k) break;

                // Set the ans[x-1] here.
                if(dp[k - times]) {
                    ans[x - 1] = true;
                    break;
                }
            }
        }
        return ans;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer array nums of size n and a positive integer k.

 An array capped by value x is obtained by replacing every element nums[i] with min(nums[i], x).

 For each integer x from 1 to n, determine whether it is possible to choose a subsequence from the array capped by x such that the sum of the chosen elements is exactly k.

 Return a 0-indexed boolean array answer of size n, where answer[i] is true if it is possible when using x = i + 1, and false otherwise.



 Example 1:

 Input: nums = [4,3,2,4], k = 5

 Output: [false,false,true,true]

 Explanation:

 For x = 1, the capped array is [1, 1, 1, 1]. Possible sums are 1, 2, 3, 4, so it is impossible to form a sum of 5.
 For x = 2, the capped array is [2, 2, 2, 2]. Possible sums are 2, 4, 6, 8, so it is impossible to form a sum of 5.
 For x = 3, the capped array is [3, 3, 2, 3]. A subsequence [2, 3] sums to 5, so it is possible.
 For x = 4, the capped array is [4, 3, 2, 4]. A subsequence [3, 2] sums to 5, so it is possible.
 Example 2:

 Input: nums = [1,2,3,4,5], k = 3

 Output: [true,true,true,true,true]

 Explanation:

 For every value of x, it is always possible to select a subsequence from the capped array that sums exactly to 3.



 Constraints:

 1 <= n == nums.length <= 4000
 1 <= nums[i] <= n
 1 <= k <= 4000
 */
