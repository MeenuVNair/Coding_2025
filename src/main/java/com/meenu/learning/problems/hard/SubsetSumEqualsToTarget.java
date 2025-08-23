package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 23/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(2^n) due to the exponential nature of the recursive calls where n is the size of the input array.
 Space Complexity:O(n) due to the maximum depth of the recursion stack, which is proportional to the size of the input array.
 */

/********************** RECURSION WITH BACKTRACKING *************************/
/** Time Limit exceeded as input size is   1 <= n = 100 */

public class SubsetSumEqualsToTarget {
    public boolean isSubsetSum(int[] arr, int target) {
        return findSubset(0, arr, 0, target);
    }

    private boolean findSubset(int i, int[] arr, int total, int target) {
        if(total == target)
            return true;
        if(i >= arr.length || total > target) {
            return false;
        }

        boolean includes = findSubset(i + 1, arr, total + arr[i], target);
        boolean excludes = findSubset(i + 1, arr, total, target);
        return includes || excludes;
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given an array arr of n integers and an integer target, determine if there is a subset of the given array with a sum equal to the given target.

 Examples:
 Input: arr = [1, 2, 7, 3], target = 6

 Output: True

 Explanation: There is a subset (1, 2, 3) with sum 6.

 Input: arr = [2, 3, 5], target = 6

 Output: False

 Explanation: There is no subset with sum 6.

 Input: arr = [7, 54, 4, 12, 15, 5], target = 9

 Output:
 True
 False

 Submit
 Constraints:
 1 <= n = 100
 1<= arr[i] <= 100
 0<= target <= 5*103

 Hint 1
 "A DP approach optimally solves this problem using a boolean DP table (dp[i][j]), where: dp[i][j] represents whether a subset of the first i elements has a sum equal to j."

 Hint 2
 "If we exclude arr[i], the result depends on dp[i-1][j]. If we include arr[i], the result depends on dp[i-1][j - arr[i]]. If either case is True, then dp[i][j] = True. Thus, the recurrence relation is: dp[i][j] = dp[i-1][j] OR dp[i-1][j - arr[i]] (if j >= arr[i])."

 Hint 3
 "Instead of a dp[n][target] table, we can use a single 1D array (dp[target]), updating from right to left to avoid overwriting values. dp[j] = dp[j] OR dp[j - arr[i]]"
 */
