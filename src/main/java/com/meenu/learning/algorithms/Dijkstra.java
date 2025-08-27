package com.meenu.learning.algorithms;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 26/08/25
 */

/*******  APPROACH ******************** 

 Dijkstra's algorithm is used to find the shortest path to all nodes in a weighted graph.
 It is similar to BFS, except it operates on weighted graphs.
 Because Dijkstra's algorithm operates on different weights, it will prioritize finding the shortest path such that the path to each destination is the "lightest".

 In other words, BFS does not revisit nodes but Dijkstra will, if it finds a shorter path (in terms of weight).

 Dijkstra's algorithm is a classic example of a greedy algorithm.
 A greedy algorithm makes the optimal choice at each step, meaning it selects the best option available at each step.
 In this case, the smallest weight.

 CONS : Dijkstra cannot handle negative weights

 */


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E logE)
 Space Complexity : O(V + E)
 */

public class Dijkstra {
    public static Map<Integer, Integer> shortestPath(int[][] edges, int n, int src) {
        Map<Integer, ArrayList<Integer[]>> adj = new HashMap<>();
        for(int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {      // set up... creating adjacency list from the input grid
            //s = src, d = dst, w = weight
            int s = edge[0], d = edge[1], w = edge[2];
            adj.get(s).add(new Integer[] {d, w});
        }

        //set up ends here

        Map<Integer, Integer> shortest = new HashMap<>(); // to store result., ie each node with the shortest path to it
        Queue<int[]> minHeap = new PriorityQueue<>((n1,n2) -> n1[0] - n2[0]); // we'll add each node (and its weight) and its neighbors to minHeap.
        // Because it is a min-heap, we will always be popping the edge with the smallest weight
        minHeap.add(new int[] {0, src});
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();;
            int w1 = curr[0], n1 = curr[1];
            if(shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);
            for(Integer[] pair : adj.get(n1)) {
                int n2 = pair[0], w2 = pair[1];
                if(!shortest.containsKey(n2))
                    minHeap.add(new int[] {w1 + w2, n2});
            }
        }
        return shortest;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Starting from A, find the length of the shortest path to every other node.
 */
