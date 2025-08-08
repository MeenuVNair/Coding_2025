package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 08/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity = O(m * n)
 Space Complexity = O(m * n)
 */

/************* DP - BOTTOM UP APPROACH ******************/

/*public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}*/

/************* DP - TOP DOWN APPROACH *******************/
/**** COMPLEXITY ANALYSIS ********************
 Time Complexity = O(m * n)
 Space Complexity = O(m * n)
 */

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return longestSubsequence(0, 0, m, n, text1, text2, memo);
    }

    private int longestSubsequence(int r, int c, int rows, int cols, String text1, String text2, int[][] memo) {
        if(r == rows || c == cols) {
            return 0;
        }
        if(memo[r][c] != -1) {
            return memo[r][c];
        }
        if(text1.charAt(r) == text2.charAt(c)) {
            memo[r][c] = 1 + longestSubsequence(r + 1, c + 1, rows, cols, text1, text2, memo);
        } else {
            memo[r][c] = Math.max(longestSubsequence(r + 1, c, rows, cols, text1, text2, memo),
                    longestSubsequence(r, c + 1, rows, cols, text1, text2, memo));
        }

        return memo[r][c];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

 A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

 For example, "ace" is a subsequence of "abcde".
 A common subsequence of two strings is a subsequence that is common to both strings.



 Example 1:

 Input: text1 = "abcde", text2 = "ace"
 Output: 3
 Explanation: The longest common subsequence is "ace" and its length is 3.
 Example 2:

 Input: text1 = "abc", text2 = "abc"
 Output: 3
 Explanation: The longest common subsequence is "abc" and its length is 3.
 Example 3:

 Input: text1 = "abc", text2 = "def"
 Output: 0
 Explanation: There is no such common subsequence, so the result is 0.


 Constraints:

 1 <= text1.length, text2.length <= 1000
 text1 and text2 consist of only lowercase English characters.
 */
