package com.meenu.coding.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 08/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(m*n) due to the nested loops iterating through the lengths of the two input strings.
 Space Complexity:O(m*n) because the dp table of size (m+1)*(n+1) is used.
 */

/************* DP - BOTTOM UP APPROACH ******************/

/*public class LongestCommonSubstring {
    public int longestCommonSubstr(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i - 1) != str2.charAt(j - 1)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}*/

/************* DP - TOP DOWN APPROACH *******************/

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(m*n) due to nested loops and memoization ensuring each cell is visited only once.
 Space Complexity:O(m*n) due to the memoization table of size m*n.
 */

public class LongestCommonSubstring {
    public int longestCommonSubstr(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        int maxLength = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxLength = Math.max(maxLength, longestSubstring(i, j, m, n, str1, str2, memo));
            }
        }
        return maxLength;
    }

    private int longestSubstring(int r, int c, int rows, int cols, String str1, String str2, int[][] memo) {
        if(r < 0 || c < 0) {
            return 0;
        }
        if(memo[r][c] != -1) {
            return memo[r][c];
        }

        if(str1.charAt(r) == str2.charAt(c)) {
            memo[r][c] = 1 + longestSubstring(r - 1, c - 1, rows, cols, str1, str2, memo);
        } else {
            memo[r][c] = 0;
        }

        return memo[r][c];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings str1 and str2, find the length of their longest common substring.



 A substring is a contiguous sequence of characters within a string.


 Examples:
 Input: str1 = "abcde", str2 = "abfce"

 Output: 2

 Explanation: The longest common substring is "ab", which has a length of 2.

 Input: str1 = "abcdxyz", str2 = "xyzabcd"

 Output: 4

 Explanation: The longest common substring is "abcd", which has a length of 4.

 Input: str1 = "abcdef", str2 = "ghijkl"

 Output:
 1
 6
 0
 2
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 n=str1.length
 m=str2.length
 1<= n, m <=103
 str1 and str2 are in lowercase alphabet

 Given two strings str1 and str2, find the length of their longest common substring.



 A substring is a contiguous sequence of characters within a string.


 Examples:
 Input: str1 = "abcde", str2 = "abfce"

 Output: 2

 Explanation: The longest common substring is "ab", which has a length of 2.

 Input: str1 = "abcdxyz", str2 = "xyzabcd"

 Output: 4

 Explanation: The longest common substring is "abcd", which has a length of 4.

 Input: str1 = "abcdef", str2 = "ghijkl"

 Output:
 1
 6
 0
 2
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 n=str1.length
 m=str2.length
 1<= n, m <=103
 str1 and str2 are in lowercase alphabet

 Hint 1
 Define dp[i][j] as the length of the longest common substring ending at str1[i-1] and str2[j-1].

 Hint 2
 "If str1[i-1] == str2[j-1]: dp[i][j]=dp[i−1][j−1]+1 Otherwise, reset dp[i][j] = 0 (since a substring must be contiguous). "


 */
