package com.meenu.learning.algorithms;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 

 Prim's algorithm is used to find a spanning tree with the minimum cost.
 Similar to Dijkstra, Prim's is also a greedy algorithm and works on weighted undirected graphs.

 What is a spanning tree? If we are given a graph G, a spanning tree is a subset of edges from G where the total weight of the edges is minimized.
 So, it is similar to Dijkstra in the sense of minimizing the cost.

 By definition a tree is a connected graph, the same is true for a minimum spanning tree.
 However, a tree cannot have any cycles. This means that if G has n nodes, our minimum spanning tree will have at most n−1 edges.

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E log V)
 Space Complexity : O(E)
 */

public class Prim {
    public List<Integer[]> minimumSpanningTree(int[][] edges, int n) {
        Map<Integer, List<Integer[]>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1], w = edge[2];
            adj.get(n1).add(new Integer[] {n2, w});
            adj.get(n2).add(new Integer[] {n1, w});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        Set<Integer> visited = new HashSet<>();
        List<Integer[]> mst = new ArrayList<>();

        for(Integer[] neighbor : adj.get(1)) {
            int node = neighbor[0], weight = neighbor[1];
            minHeap.add(new int[] {weight, 1, node});
        }
        visited.add(1);
        while(visited.size() < n) {
            int[] curr = minHeap.remove();
            int w1 = curr[0], n1 = curr[1], n2 = curr[2];
            if(visited.contains(n2))
                continue;
            visited.add(n2);
            mst.add(new Integer[] {n1, n2});
            for(Integer[] pair : adj.get(n2)) {
                Integer neighbor = pair[0], weight = pair[1];
                if(!visited.contains(neighbor))
                    minHeap.add(new int[] {weight, n2, neighbor});
            }
        }
        return mst;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a list of edges of a connected undirected graph, with nodes numbered from 1 to n, return a list edges making up the minimum spanning tree.
 */
