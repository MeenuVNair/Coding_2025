package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 28/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(V+E) due to visiting all vertices and edges in DFS and BFS
 Space Complexity:O(V) due to the visited set and recursion depth in DFS/queue size in BFS
 */

public class TraversalTechniques {
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++) {
            if(!visited.contains(i))
                dfs(i, adj, visited, result);
        }
        return result;
    }

    private void dfs(int source, List<List<Integer>> adj, Set<Integer> visited, List<Integer> result) {
        visited.add(source);
        result.add(source);

        for(Integer next : adj.get(source)) {
            if(!visited.contains(next))
                dfs(next, adj, visited, result);
        }
    }


    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < V; i++) {
            if(!visited.contains(i))
                bfs(i, adj, visited, result);
        }
        return result;
    }

    private void bfs(int source, List<List<Integer>> adj, Set<Integer> visited, List<Integer> result) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited.add(source);

        while(!q.isEmpty()) {
            int curr = q.poll();
            result.add(curr);

            for(Integer next : adj.get(curr)) {
                if(!visited.contains(next)) {
                    q.add(next);
                    visited.add(next);
                }
            }
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an undirected connected graph with V vertices numbered from 0 to V-1, the task is to implement both Depth First Search (DFS) and Breadth First Search (BFS) traversals starting from the 0th vertex. The graph is represented using an adjacency list where adj[i] contains a list of vertices connected to vertex i. Visit nodes in the order they appear in the adjacency list.

 Examples:

 Input: V = 5, adj = [[2, 3, 1], [0], [0, 4], [0], [2]]

 Output:[0, 2, 4, 3, 1], [0, 2, 3, 1, 4]

 Explanation:

 DFS: Start from vertex 0. Visit vertex 2, then vertex 4, backtrack to vertex 0, then visit vertex 3, and finally vertex 1. The traversal is 0 → 2 → 4 → 3 → 1.

 BFS: Start from vertex 0. Visit vertices 2, 3, and 1 (in the order they appear in the adjacency list). Then, visit vertex 4 from vertex 2. The traversal is 0 → 2 → 3 → 1 → 4.

 Input: V = 4, adj = [[1, 3], [2, 0], [1], [0]]

 Output: [0, 1, 2, 3], [0, 1, 3, 2]

 Explanation:

 DFS: Start from vertex 0. Visit vertex 1, then vertex 2, backtrack to vertex 0, then visit vertex 3. The traversal is 0 → 1 → 2 → 3.

 BFS: Start from vertex 0. Visit vertices 1 and 3, then visit vertex 2 from vertex 1. The traversal is 0 → 1 → 3 → 2.

 Hint 1
 "Use recursion (or a stack) to explore as deep as possible before backtracking. Maintain a visited array to mark visited nodes and avoid cycles. Start from vertex 0 and visit nodes in the order they appear in adj[i]."

 Hint 2
 "Use a queue to explore nodes level by level (FIFO order). Begin from 0, mark it as visited, and process all connected nodes before moving deeper. The traversal order follows the order of neighbors in adj[i]."
 */
