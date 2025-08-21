package com.meenu.coding.problems.medium;


import java.util.HashSet;
import java.util.Set;

/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */
public class MatrixDFS {
    public int countPaths(int[][] grid) {
        return dfs(grid, 0, 0, new HashSet<>());
    }

    int dfs(int[][] grid, int r, int c, Set<String> visit) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if(Math.min(r, c) < 0 ||
                r == ROWS ||
                c == COLS ||
                visit.contains(r + "," + c) ||
                grid[r][c] == 1) {
            return 0;
        }
        if(r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visit.add(r + "," + c);
        int count = 0;

        count += dfs(grid, r + 1, c, visit);
        count += dfs(grid, r - 1, c, visit);
        count += dfs(grid, r, c + 1, visit);
        count += dfs(grid, r, c - 1, visit);

        visit.remove(r + "," + c);

        return count;
    }
}

/**
 You are given a binary matrix Grid where 0s represent land and 1s represent rocks that can not be traversed.

 Return the number of unique paths from the top-left corner of Grid to the bottom-right corner such that all traversed cells are land cells. You may only move vertically or horizontally through land cells. For an individual unique path you cannot visit the same cell twice.

 Example 1:

 Input: grid = [
 [0, 0, 0, 0],
 [1, 1, 0, 0],
 [0, 0, 0, 1],
 [0, 1, 0, 0]
 ]

 Output:
 2
 */
