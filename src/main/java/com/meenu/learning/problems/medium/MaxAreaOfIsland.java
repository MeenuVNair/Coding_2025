package com.meenu.learning.problems.medium;

/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

/*******  APPROACH ********************
 *
 We traverse the grid, and when we encounter a 1, we initialize a variable area.
 We then start a DFS from that cell to visit all connected 1's recursively, marking them as 0 to indicate they are visited.
 At each recursion step, we increment area.
 After completing the DFS, we update maxArea, which tracks the maximum area of an island in the grid, if maxArea < area.
 Finally, after traversing the grid, we return maxArea.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[r].length; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length ||
                grid[r][c] == 0) {
            return 0;
        }

        grid[r][c] = 0;
        int area = 1;

        area += dfs(grid, r + 1, c);
        area += dfs(grid, r - 1, c);
        area += dfs(grid, r, c + 1);
        area += dfs(grid, r, c - 1);

        return area;
    }
}

/**
 You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 The area of an island is the number of cells with a value 1 in the island.

 Return the maximum area of an island in grid. If there is no island, return 0.



 Example 1:


 Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 Output: 6
 Explanation: The answer is not 11, because the island must be connected 4-directionally.
 Example 2:

 Input: grid = [[0,0,0,0,0,0,0,0]]
 Output: 0


 Constraints:

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 50
 grid[i][j] is either 0 or 1.
 */
