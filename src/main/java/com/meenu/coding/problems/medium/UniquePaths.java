package com.meenu.coding.problems.medium;


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

/************* DP - TOP DOWN APPROACH *******************/

/*public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        return calculatePaths(0, 0, m, n, cache);
    }

    private int calculatePaths(int r, int c, int rows, int cols, int[][] cache) {
        if(r == rows || c == cols) {
            return 0;
        }

        if(cache[r][c] > 0) {
            return cache[r][c];
        }

        if(r == rows - 1 && c == cols - 1) {
            return 1;
        }

        cache[r][c] = calculatePaths(r + 1, c, rows, cols, cache) + calculatePaths(r, c + 1, rows, cols, cache);

        return cache[r][c];
    }
}*/

/************* DP - BOTTOM UP APPROACH ******************/

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity = O(m * n)
 Space Complexity = O(n)
 */

public class UniquePaths {
    public int uniquePaths(int m, int n) {
       int[] prevRow = new int[n];

       for(int i = m - 1; i >= 0; i--) {
           int[] currRow = new int[n];
           currRow[n - 1] = 1;
           for(int j = n - 2; j >= 0; j--) {
               currRow[j] = currRow[j + 1] + prevRow[j];
           }
           prevRow = currRow;
       }
       return prevRow[0];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

 Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

 The test cases are generated so that the answer will be less than or equal to 2 * 109.

 Example 1:

 Input: m = 3, n = 7
 Output: 28
 Example 2:

 Input: m = 3, n = 2
 Output: 3
 Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Down -> Down
 2. Down -> Down -> Right
 3. Down -> Right -> Down

 Constraints:

 1 <= m, n <= 100
 */
