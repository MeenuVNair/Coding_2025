package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 
 Using Prims's Algorithm
 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n^2 log n)
 Space Complexity : O(n^2)
 */

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for(int i = 0; i < N; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for(int j = i + 1; j < N; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new Integer[]{distance, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new Integer[]{distance, i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        Set<Integer> visited = new HashSet<>();
        minHeap.add(new int[]{0, 0});
        int result = 0;
        while(visited.size() < N) {
            int[] curr = minHeap.remove();
            int w1 = curr[0], n1 = curr[1];
            if(visited.contains(n1))
                continue;
            visited.add(n1);
            result += w1;
            for(Integer[] pair : adj.getOrDefault(n1, Collections.emptyList())) {
                int w2 = pair[0], n2 = pair[1];
                if(!visited.contains(n2))
                    minHeap.add(new int[] {w2, n2});
            }
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a 2-D integer array points, where points[i] = [xi, yi]. Each points[i] represents a distinct point on a 2-D plane.

 The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between the two points, i.e. |xi - xj| + |yi - yj|.

 Return the minimum cost to connect all points together, such that there exists exactly one path between each pair of points.

 Example 1:


 Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]

 Output: 10
 Constraints:

 1 <= points.length <= 1000
 -1000 <= xi, yi <= 1000


 Recommended Time & Space Complexity
 You should aim for a solution as good or better than O((n^2)logn) time and O(n^2) space, where n is the number of points.


 Hint 1
 Think of this problem as a graph, where the given points represent nodes. We need to connect these nodes into a single component by creating edges. Can you think of an advanced graph algorithm that can be used to connect all points into one component?


 Hint 2
 We use Kruskal's algorithm along with Union-Find (DSU) to connect nodes into components. The final component forms the minimum spanning tree (MST), where the edges between nodes are weighted by the Manhattan distance, and the total weight of the tree is minimized. How would you implement this?


 Hint 3
 We create the possible edges by iterating through every pair of points and calculating the weights as the Manhattan distance between them. Next, we sort the edges in ascending order based on their weights, as we aim to minimize the cost. Then, we traverse through these edges, connecting the nodes and adding the weight of the edge to the total cost if the edge is successfully added. The final result will be the minimum cost.
 */
