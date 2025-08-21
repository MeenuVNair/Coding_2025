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

 */

public class MatrixBFS {
    public int shortestPath(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();

        queue.add(new int[]{0, 0});
        visit.add("0, 0");

        int length = 0;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            for(int i = 0; i < qSize; i++) {
                int pair[] = queue.poll();
                int r = pair[0], c = pair[1];

                if(r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] neighbours = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for(int j = 0; j < 4; j++) {
                    int newC = neighbours[j][0], newR = neighbours[j][1];

                    if(newC < 0 || newR < 0 || newC == ROWS || newR == COLS ||
                            visit.contains(newC + "," + newR) || grid[newC][newR] == 1) {
                        continue;
                    }

                    queue.add(neighbours[j]);
                    visit.add(newC + "," + newR);
                }
            }
            length++;
        }
        return -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 You are given a binary matrix Grid where 0s represent land and 1s represent rocks that can not be traversed.

 Return the length of the shortest path from the top-left corner of Grid to the bottom-right corner such that all traversed cells are land cells. You may only move vertically or horizontally through land cells.

 Note:

 If there is no such path, return -1.
 The length of a path is the number of moves from the starting cell to the ending cell.
 Example 1:

 Input: grid = [
 [0, 0, 0, 0],
 [1, 1, 0, 0],
 [0, 0, 0, 1],
 [0, 1, 0, 0]
 ]

 Output:
 6

 */
