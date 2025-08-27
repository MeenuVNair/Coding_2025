package com.meenu.learning.problems.hard;

import com.meenu.learning.util.UnionFind;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 
    Using Prim's and Kruskal's algorithm
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E * log V)
 Space Complexity : O(E)
 */

/********************* Using PRIM's ALGORITHM **************************/

/*public class FindMSTWeight {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        // Min-Heap to store pair of {edge, node}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);

        // Push any arbitrary initial node
        minHeap.add(new int[]{0, 0});

        // Visited array
        Set<Integer> visited = new HashSet<>();

        // To store the weight of MST
        int sum = 0;
        while(visited.size() < V) {
            int[] curr = minHeap.remove(); // Get the pair with minimum edge
            int w1 = curr[0]; // Get the edge weight
            int n1 = curr[1]; // Get the node
            if(visited.contains(n1)) // If the node is already visited, skip the iteration
                continue;
            visited.add(n1); // Otherwise, mark the node as visited
            sum += w1; // Update the weight of MST
            for(List<Integer> pair : adj.get(n1)) {  // Traverse all the edges of the node
                int n2 = pair.get(0), w2 = pair.get(1); // Get the adjacent node and weight
                if(!visited.contains(n2)) // Add the pair to min-heap if the node is not visited already
                    minHeap.add(new int[] {w2, n2});
            }
        }
        return sum;  // Return the weight of MST
    }
}*/

/**************************** USING KRUSKAL's ALGORITHM *********************/

public class FindMSTWeight {
    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        UnionFind un = new UnionFind(V);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        minHeap.add(new int[] {0, 0});

        for(int i = 0; i < V; i++) {
            for(List<Integer> it : adj.get(i)) {
                int n1 = i;
                int n2 = it.get(0);
                int w = it.get(1);
                minHeap.add(new int[] {w, n1, n2});
            }
        }

        int sum = 0;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int w = curr[0];
            int n1 = curr[1];
            int n2 = curr[2];

            if(!un.union(n1, n2))
                continue;
            sum += w;
        }
        return sum;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a weighted, undirected, and connected graph with V vertices numbered from 0 to V-1 and E edges.

 The ith edge is represented by [ai,bi,wi], where ai and bi denotes the endpoint of the edge and the wi denotes the weight of the edge.

 Find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph.

 A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.

 Note : The input to the function in code editor is giving in form of adjacency list.

 Examples:

 Input: V = 4, edges = [[0, 1, 1], [1, 2, 2], [2, 3, 3], [0, 3, 4]]

 Output: 6

 Explanation:

 Edges included in the MST:

 [0, 1, 1] with weight 1

 [1, 2, 2] with weight 2

 [2, 3, 3] with weight 3

 The total weight of the MST is 1 + 2 + 3 = 6. These edges form a spanning tree that connects all vertices (0, 1, 2, 3) with the minimum possible total edge weight, satisfying the MST properties.

 Input: V = 3, edges = [[0, 1, 5], [1, 2, 10], [2,0,15]]

 Output: 15

 Explanation:

 Edges included in the MST:

 [0, 1, 5] with weight 5

 [1, 2, 10] with weight 10

 The total weight of the MST is 5+10 = 15

 Constraints:
 2 ≤ V ≤ 103
 V-1 ≤ E ≤ 104
 1 ≤ w ≤ 105

 Hint 1
 Sort edges in ascending order of weight. Use Disjoint Set (Union-Find with Path Compression & Union by Rank) to keep track of connected components. Iterate over sorted edges. If an edge does not form a cycle, include it in the MST and merge the components. If V-1 edges have been included, stop (MST is complete). Return the sum of MST edge weights.

 Hint 2
 Use a priority queue (min-heap) to always expand the lightest edge connected to the MST. Maintain a visited set and a cost array to track the cheapest edge connecting each vertex to the MST. Extract the minimum-weight edge and expand the MST iteratively until all vertices are included. Return the sum of MST edge weights.
 */
