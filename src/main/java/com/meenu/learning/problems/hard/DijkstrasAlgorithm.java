package com.meenu.learning.problems.hard;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O((V+E)logV), where V is the number of vertices and E is the number of edges. Initialization and final array creation take O(V), while the main Dijkstra's algorithm takes O((V+E)logV).
 Space Complexity:O(V+E), where V is the number of vertices and E is the number of edges. The priority queue can store up to E elements in the worst case, and the shortest distance map stores up to V elements. The distance array also takes O(V) space.
 */

public class DijkstrasAlgorithm {
    public  int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0]- n2[0]);
        Map<Integer, Integer> shortest = new HashMap<>();

        minHeap.add(new int[] {0, S});

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int w1 = curr[0];
            int n1 = curr[1];
            if(shortest.containsKey(n1))
                continue;
            shortest.put(n1, w1);

            for(List<Integer> pair : adj.get(n1)) {
                int n2 = pair.get(0), w2 = pair.get(1);
                if(!shortest.containsKey(n2))
                    minHeap.add(new int[] {w1 + w2, n2});
            }
        }
        int[] distance = new int[V];
        Arrays.fill(distance, (int) 1e9);
        for(Map.Entry<Integer, Integer> entry : shortest.entrySet()) {
            distance[entry.getKey()] = entry.getValue();
        }
        return distance;
    }

    public static void main(String[] args) {
        int V = 2, S = 0;

        // Create adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> node0 = new ArrayList<>();
        node0.add(new ArrayList<>(Arrays.asList(1, 9)));
        adj.add(node0);

        ArrayList<ArrayList<Integer>> node1 = new ArrayList<>();
        node1.add(new ArrayList<>(Arrays.asList(0, 9)));
        adj.add(node1);

        /* Creating an instance of
        DijkstrasAlgorithm class */
        DijkstrasAlgorithm sol = new DijkstrasAlgorithm();

        /* Function call to find the shortest distance
        of each node from the source node */
        int[] ans = sol.dijkstra(V, adj, S);

        // Output
        System.out.print("The shortest distance of nodes from the source node is: ");
        for (int i = 0; i < V; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a weighted, undirected graph of V vertices, numbered from 0 to V-1, and an adjacency list adj where adj[i] is a list of lists containing two integers where the first integer of each list j denotes there is edge between i and j , second integers corresponds to the weight of that edge .

 Given a source node S. Find the shortest distance of all the vertex from the source vertex S. Return a list of integers denoting shortest distance between each node and source vertex S. If a vertex is not reachable from source then its distance will be 109.

 Examples:

 Input: V = 2, adj [] = [[[1, 9]], [[0, 9]]], S=0

 Output: [0, 9]

 Explanation:

 The shortest distance from node 0(source) to node 0 is 0 and the shortest distance from node 0 to node 1 is 9.

 Input: V = 3,adj = [[[1, 1], [2, 6]], [[2, 3], [0, 1]], [[1, 3], [0, 6]]], S=2

 Output: [4, 3, 0]

 Explanation:

 For node 0, the shortest path is 2->1->0 (distance=4)

 For node 1, the shortest path is 2->1 (distance=3)

 Input: V=4, adj = [[[1, 1], [3, 2]],[[0, 1], [2, 4]],[[1, 4], [3, 3]], [[0, 2], [2, 3]]], S=0

 Output:
 [1, 5, 2, 0]
 [0, 5, 1, 2]
 [0, 1, 5, 2]
 [0, 1, 1, 5]

 Submit
 Constraints:
 1 ≤ V ≤ 10000
 0 ≤ adj[i][j] ≤ 10000
 1 ≤ adj.size() ≤ [ (V*(V - 1)) / 2 ]
 0 ≤ S < V

 Hint 1
 Initialize a distance array dist[] where dist[i] stores the shortest known distance from S to i. Set all distances to 10^9 (infinity) except dist[S] = 0. Use a Min-Heap (Priority Queue) to always expand the current closest node.

 Hint 2
 For each node, check all adjacent nodes and relax their distances (dist[v] = min(dist[v], dist[u] + weight)). Continue until all nodes are processed.

 */
