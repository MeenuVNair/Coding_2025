package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity: O(M*N) where M is the number of rows and N is the number of columns in the grid, due to visiting each cell potentially once.
 Space Complexity: O(M*N) in the worst case due to the depth of the DFS recursion, which can be at most M*N if the entire grid is land.
 */

public class NumberOfDistinctIslands {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;

        int numIslands = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    public int dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
                grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
        dfs(grid, i + 1, j + 1);
        dfs(grid, i - 1, j + 1);
        dfs(grid, i + 1, j - 1);
        dfs(grid, i - 1, j - 1);

        return 1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a grid of size N x M (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) and ‘1's(Land). Find the number of islands.

 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.


 Examples:




 Input: grid = [ ["1", "1", "1", "0", "1"], ["1", "0", "0", "0", "0"], ["1", "1", "1", "0", "1"], ["0", "0", "0", "1", "1"] ]

 Output: 2

 Explanation: This grid contains 2 islands. Each '1' represents a piece of land, and the islands are formed by connecting adjacent lands horizontally or vertically. Despite some islands having a common edge, they are considered separate islands because there is no land connectivity in any of the eight directions between them. Therefore, the grid contains 2 islands.

 Input: grid = [ ["1", "0", "0", "0", "1"], ["0", "1", "0", "1", "0"], ["0", "0", "1", "0", "0"], ["0", "1", "0", "1"," 0"] ]

 Output: 1

 Explanation: In the given grid, there's only one island as all the '1's are connected either horizontally, vertically, or diagonally, forming a single contiguous landmass surrounded by water on all sides.

 Input: grid = [ ["1", "1", "1", "1", "0"], ["1", "1", "0", "1", "0"], ["1", "1", "0", "0", "0"], ["0", "0", "0", "0", "0"] ]

 Output:
 1
 2
 4
 3

 Submit
 Constraints:
 ·  N == grid.length

 ·  M == grid[i].length

 ·  1 <= N, M <= 300

 ·  grid[i][j] is '0' or '1'.
 */
