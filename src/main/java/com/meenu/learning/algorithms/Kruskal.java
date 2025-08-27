package com.meenu.learning.algorithms;

import com.meenu.learning.util.UnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 
 Kruskal's algorithm, similar to Prim's algorithm, is another algorithm for finding the minimum spanning tree in an undirected weighted graph.
 Kruskal's is also a greedy algorithm that works better on sparse graphs. while Prim's works better on denser graphs.

 Kruskal's algorithm works by sorting the edges in increasing (or rather non-decreasing) order of weights; then, starting with an initially empty tree, considers all edges, and adds the edge with the minimum weight to our MST, if it does not result in a cycle.
 Kruskal's will discard an edge if it results in a cycle.

 Kruskal's makes use of the union-find data structure to detect if adding an edge would result in a cycle

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E * log V)
 Space Complexity : O(E)
 */

public class Kruskal {
    public List<Integer[]> minimumSpanningTree(int[][] edges, int n) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0]- n2[0]);
        for(int[] edge : edges) {
            int n1 = edge[0], n2 = edge[1], weight = edge[3];
            minHeap.add(new int[] {weight, n1, n2});
        }

        List<Integer[]> mst = new ArrayList<>();
        UnionFind un = new UnionFind(n);
        while(mst.size() < n - 1) {
            int[] curr = minHeap.remove();
            int w1 = curr[0], n1 = curr[1], n2 = curr[2];
            if(!un.union(n1, n2))
                continue;
            mst.add(new Integer[] {n1, n2});
        }
        return mst;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an list of edges of a connected undirected graph, with nodes numbered from 1 to n, return a list edges making up the minimum spanning tree.
 */
