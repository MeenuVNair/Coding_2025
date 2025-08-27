package com.meenu.learning.problems.hard;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 
 Used Dijkstra's algorithm
 But topological sort is the preferred approach here, which will run with the below complexities:
 Time = O(N + M)
 Space = O(N + M)
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(M*log(N)), where M is the number of edges and N is the number of nodes due to the priority queue operations.
 Space Complexity:O(N + M), where N is the number of nodes for storing the shortest distances and M is the number of edges for the adjacency list.
 */

public class ShortestPathInDAG {
    public int[] shortestPath(int N, int M, int[][] edges) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1], w = edge[2];
            adj.get(n1).add(new Integer[]{n2, w});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        Map<Integer, Integer> shortest = new HashMap<>();
        minHeap.add(new int[]{0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int w1 = curr[0];
            int n1 = curr[1];
            if (shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);
            for (Integer[] pair : adj.get(n1)) {
                int n2 = pair[0], w2 = pair[1];
                if (!shortest.containsKey(n2))
                    minHeap.add(new int[]{w1 + w2, n2});
            }
        }

        int distance[] = new int[N];
        Arrays.fill(distance, -1);
        for (Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            distance[entry.getKey()] = entry.getValue();
        }
        return distance;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a Directed Acyclic Graph of N vertices from 0 to N-1 and M edges and a 2D Integer array edges, where there is a directed edge from vertex edge[i][0] to vertex edge[i][1] with a distance of edge[i][2] for all i.

 Find the shortest path from source vertex to all the vertices and if it is impossible to reach any vertex, then return -1 for that vertex. The source vertex is assumed to be 0.

 Examples:

 Input: N = 4, M = 2 edge = [[0,1,2],[0,2,1]]

 Output: 0 2 1 -1

 Explanation:

 Shortest path from 0 to 1 is 0->1 with edge weight 2.

 Shortest path from 0 to 2 is 0->2 with edge weight 1.

 There is no way we can reach 3, so it's -1 for 3.

 Input: N = 6, M = 7 edge = [[0,1,2],[0,4,1],[4,5,4],[4,2,2],[1,2,3],[2,3,6],[5,3,1]]

 Output: 0 2 3 6 1 5

 Explanation:

 Shortest path from 0 to 1 is 0->1 with edge weight 2.

 Shortest path from 0 to 2 is 0->4->2 with edge weight 1+2=3.

 Shortest path from 0 to 3 is 0->4->5->3 with edge weight 1+4+1=6.

 Shortest path from 0 to 4 is 0->4 with edge weight 1.

 Shortest path from 0 to 5 is 0->4->5 with edge weight 1+4=5.

 Constraints:
 1 ≤ N,M ≤ 5*104
 0 ≤ edge[i][0],edge[i][1] < N-1
 1 ≤ edge[i][2] < 104

 Similar Problems

 Hint 1
 Since the graph is a Directed Acyclic Graph (DAG), use topological sorting to process vertices in a valid order. After sorting, relax edges following the topological order to compute shortest paths efficiently.

 Hint 2
 Unlike Dijkstra’s algorithm (which uses a priority queue), topological sorting followed by relaxation solves it in O(N + M) time. This approach works because in a DAG, edges always point forward, preventing cycles.
 */
