package com.meenu.learning.problems.hard;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 
 Dijkstra's algorithm
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(M + N + E logV) where M is number of edges, N is number of vertices, E is the number of edges and V is the number of vertices.
 Space Complexity:O(N + E), where N is the number of nodes and E is the number of edges.
 */

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public int[] shortestPath(int[][] edges, int N, int M) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for(int i = 0; i <= N; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1];
            adj.get(n1).add(new Integer[] {n2, 1});
            adj.get(n2).add(new Integer[] {n1, 1});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        Map<Integer, Integer> shortest = new HashMap<>();
        minHeap.add(new int[] {0, 0});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int w1 = curr[0];
            int n1 = curr[1];
            if(shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);
            for(Integer[] pair : adj.get(n1)) {
                int n2 = pair[0], w2 = pair[1];
                if(!shortest.containsKey(n2))
                    minHeap.add(new int[] {w1 + w2, n2});
            }
        }

        int distance[] = new int[N];
        Arrays.fill(distance, -1);
        for(Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            distance[entry.getKey()] = entry.getValue();
        }
        return distance;
    }

    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
                {0, 1}, {0, 3}, {3, 4},
                {4, 5}, {5, 6}, {1, 2},
                {2, 6}, {6, 7}, {7, 8}, {6, 8}
        };

        /* Creating an instance of
        ShortestPathInUndirectedGraphWithUnitWeights class */
        ShortestPathInUndirectedGraphWithUnitWeights sol = new ShortestPathInUndirectedGraphWithUnitWeights();

        /* Function call to determine shortest paths */
        int[] ans = sol.shortestPath(edges, N, M);

        // Output
        System.out.println("The shortest distance of every node from source node is:");
        for (int i = 0; i < N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an Undirected Graph of N vertices from 0 to N-1 and M edges and a 2D Integer array edges, where there is a edge from vertex edges[i][0] to vertex edges[i][1] of unit weight.

 Find the shortest path from the source to all other nodes in this graph. In this problem statement, we have assumed the source vertex to be ‘0’. If a vertex is unreachable from the source node, then return -1 for that vertex.

 Examples:
 Input: n = 9, m = 10, edges = [[0,1],[0,3],[3,4],[4,5],[5, 6],[1,2],[2,6],[6,7],[7,8],[6,8]]

 Output: 0 1 2 1 2 3 3 4 4

 Explanation:

 The above output array shows the shortest path to all

 the nodes from the source vertex (0), Dist[0] = 0, Dist[1] = 1 , Dist[2] = 2 , …. Dist[8] = 4.Where Dist[node] is the shortest path between src and the node. For a node, if the value of Dist[node]= -1, then we conclude that the node is unreachable from the src node.

 Input: n = 8, m = 10, edges =[[1,0],[2,1],[0,3],[3,7],[3,4],[7,4],[7,6],[4,5],[4,6],[6,5]]

 Output: 0 1 2 1 2 3 3 2

 Explanation:

 The above output list shows the shortest path to all the nodes from the source vertex (0), Dist[0] = 0, Dist[1] = 1, Dist[2] = 2,.....Dist[7] = 2.


 Hint 1
 Perform a topological sort to find an ordering of nodes where every node appears before its dependent nodes. Initialize a distance array with inf (or a large value) for all nodes, except for the source node (0), which is initialized to 0.

 Hint 2
 Process the nodes in topological order, updating the shortest distances for all adjacent nodes using edge relaxation:dist[v]=min(dist[v],dist[u]+weight[u→v]). If a node remains unreachable (inf distance), return -1 for that node
 */
