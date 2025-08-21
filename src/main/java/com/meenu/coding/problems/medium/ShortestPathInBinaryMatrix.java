package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*******  APPROACH ********************
Do a BFS to find the shortest path, but here it will be 8-directional, that means we should check diagonal nodes as well
 */

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
            return -1;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0},
                                {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        Deque<int[]> queue = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();

        queue.add(new int[]{0, 0});
        visit.add("0,0");

        int length = 1;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] pair = queue.poll();
                int r = pair[0], c = pair[1];

                if (r == N - 1 && c == N - 1) {
                    return length;
                }

                for (int j = 0; j < 8; j++) {
                    int newR = r + directions[j][0], newC = c + directions[j][1];
                    if (newR < 0 || newC < 0 || newR == N || newC == N ||
                            visit.contains(newR + "," + newC) || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(new int[]{newR, newC});
                    visit.add(newR + "," + newC);
                }
            }
            length++;
        }
        return -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

 A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

 All the visited cells of the path are 0.
 All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
 The length of a clear path is the number of visited cells of this path.



 Example 1:


 Input: grid = [[0,1],[1,0]]
 Output: 2
 Example 2:


 Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
 Output: 4
 Example 3:

 Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
 Output: -1


 Constraints:

 n == grid.length
 n == grid[i].length
 1 <= n <= 100
 grid[i][j] is 0 or 1
 */
