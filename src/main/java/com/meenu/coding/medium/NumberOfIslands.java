package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

/********************  APPROACH  *****************

 We can use the Depth First Search (DFS) algorithm to traverse each group independently.
 We iterate through each cell of the grid.
 When we encounter a 1, we perform a DFS starting at that cell and recursively visit every other 1 that is reachable.
 During this process, we mark the visited 1's as 0 to ensure we don't revisit them, as they belong to the same group.
 The number of groups corresponds to the number of islands.

 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int r, int c) {

        if(r < 0 || c < 0 || r == grid.length || c == grid[0].length ||
                grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}

/**
 Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



 Example 1:

 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1
 Example 2:

 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3


 Constraints:

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 300
 grid[i][j] is '0' or '1'.
 */
