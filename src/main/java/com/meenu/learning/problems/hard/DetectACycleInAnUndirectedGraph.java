package com.meenu.learning.problems.hard;

import java.util.*;

/**
 * @author Meenu V. Nair
 * @created 28/08/25
 */

/*******  APPROACH 1 ********************
 DFS
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E + V)
 Space Complexity : O(V)
 */

/*public class DetectACycleInAnUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < V; i++) {
            if(!visited.contains(i)) {
                if(dfs(i, -1, adj, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean dfs(int current, int prev, List<Integer>[] adj, Set<Integer> visited) {
        visited.add(current);
        for(Integer next : adj[current]) {
            if(!visited.contains(next)) {
                if(dfs(next, current, adj, visited))
                    return true;
            } else if(next != prev) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectACycleInAnUndirectedGraph obj = new DetectACycleInAnUndirectedGraph();
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        boolean ans = obj.isCycle(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}*/


/*******  APPROACH 2 ********************
 BFS
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E + V)
 Space Complexity : O(V)
 */

public class DetectACycleInAnUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < V; i++) {
            if(!visited.contains(i)) {
                if(bfs(i, adj, visited))
                    return true;
            }
        }
        return false;
    }
    private boolean bfs(int i, List<Integer>[] adj, Set<Integer> visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, -1});
        visited.add(i);

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int node = current[0];
            int parent = current[1];

            for(Integer next : adj[node]) {
                if(!visited.contains(next)) {
                    q.add(new int[] {next, node});
                    visited.add(next);
                } else if(next != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectACycleInAnUndirectedGraph obj = new DetectACycleInAnUndirectedGraph();
        int V = 6;
        List<Integer> adj[] = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 3));
        adj[1].addAll(Arrays.asList(0, 2, 4));
        adj[2].addAll(Arrays.asList(1, 5));
        adj[3].addAll(Arrays.asList(0, 4));
        adj[4].addAll(Arrays.asList(1, 3, 5));
        adj[5].addAll(Arrays.asList(2, 4));

        boolean ans = obj.isCycle(V, adj);

        // Output
        if (ans)
            System.out.println("The given graph contains a cycle.");
        else
            System.out.println("The given graph does not contain a cycle.");
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.

 Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).


 Examples:


 Input: V = 6, adj= [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]

 Output: True

 Explanation: The graph contains a cycle: 0 ->1 -> 2 -> 5 -> 4 -> 1.

 Input: V = 4, adj= [[1, 2], [0], [0, 3], [2]]

 Output: False

 Explanation: The graph does not contain any cycles.

 Constraints:
 E=number of edges
 1 ≤ V, E ≤ 104

 Hint 1
 "Use DFS with a visited array to track traversal. A cycle exists if a visited node is reached again and it is not the parent node."

 Hint 2
 "Use Union-Find to track connected components. If an edge connects two nodes already in the same set, a cycle is detected."
 */
