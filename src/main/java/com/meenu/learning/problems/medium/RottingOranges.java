package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

import java.util.ArrayDeque;
import java.util.Queue;

/*******  APPROACH ********************
 We traverse the grid and store the rotten oranges in a queue.
 We then run a BFS, processing the current level of rotten oranges and visiting the adjacent cells of each rotten orange.
 We only insert the adjacent cell into the queue if it contains a fresh orange.
 This process continues until the queue is empty. The level at which the BFS stops is the answer.
 However, we also need to check whether all oranges have rotted by traversing the grid.
 If any fresh orange is found, we return -1; otherwise, we return the level.
 */

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int time = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    fresh++;
                if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(fresh > 0 && !queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i < qSize; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                for(int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if(newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length &&
                            grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        queue.add(new int[]{newR, newC});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an m x n grid where each cell can have one of three values:

 0 representing an empty cell,
 1 representing a fresh orange, or
 2 representing a rotten orange.
 Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

 Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.



 Example 1:


 Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 Output: 4
 Example 2:

 Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 Output: -1
 Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 Example 3:

 Input: grid = [[0,2]]
 Output: 0
 Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.


 Constraints:

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 10
 grid[i][j] is 0, 1, or 2.
 */
