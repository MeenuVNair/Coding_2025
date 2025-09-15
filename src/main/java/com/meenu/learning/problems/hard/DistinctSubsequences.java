package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 15/09/25
 */

/*******  APPROACH ******************** 
 DP - recursion
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(2^n)
 Space Complexity : O(n)

 where n is the length of string s
 */

/*public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        return recursion(0, 0, s, t);
    }

    private int recursion(int i, int j, String s, String t) {
        if(j == t.length())
            return 1;
        if(i == s.length())
            return 0;

        if(s.charAt(i) == t.charAt(j))
            return recursion(i + 1, j + 1, s, t) + recursion(i + 1, j, s, t);
        else return recursion(i + 1, j, s, t);
    }
}*/


/*******  APPROACH ********************
 DP - top down
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n * m)
 Space Complexity : O(n * m)

 where n is the length of string s and m is the length of string t
 */

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int[][] cache = new int[s.length()][t.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < t.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(0, 0, s, t, cache);
    }

    private int dfs(int i, int j, String s, String t, int[][] cache) {
        if(j == t.length())
            return 1;
        if(i == s.length())
            return 0;
        if(cache[i][j] != -1)
            return cache[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            cache[i][j] = dfs(i + 1, j + 1, s, t, cache) + dfs(i + 1, j, s, t, cache);
        } else {
            cache[i][j] = dfs(i + 1, j, s, t, cache);
        }
        return cache[i][j];
    }

    public static void main(String[] args) {
        DistinctSubsequences obj = new DistinctSubsequences();
       // String s = "rabbbit", t = "rabbit";
       // System.out.println(obj.numDistinct(s, t)); //3
        String s = "babgbag", t = "bag";
        System.out.println(obj.numDistinct(s, t)); //5
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings s and t, return the number of distinct subsequences of s which equals t.

 The test cases are generated so that the answer fits on a 32-bit signed integer.



 Example 1:

 Input: s = "rabbbit", t = "rabbit"
 Output: 3
 Explanation:
 As shown below, there are 3 ways you can generate "rabbit" from s.
 rabbbit
 rabbbit
 rabbbit
 Example 2:

 Input: s = "babgbag", t = "bag"
 Output: 5
 Explanation:
 As shown below, there are 5 ways you can generate "bag" from s.
 babgbag
 babgbag
 babgbag
 babgbag
 babgbag


 Constraints:

 1 <= s.length, t.length <= 1000
 s and t consist of English letters.
 */
