package com.meenu.learning.algorithms;


/**
 * @author Meenu V. Nair
 * @created 28/08/25
 */

/*******  APPROACH ******************** 
 Topological sort is a way of sorting a directed acyclic graph (DAG) such that each node comes before its dependent nodes.
 A simple example of this is university courses.
 There are some courses that can be taken without any pre-requisites and then there are those that have pre-requisites,
 i.e. you cannot take them unless you have taken other courses first.

 To traverse the graph, we can make use of either BFS or DFS

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

public class TopologicalSort {
    public List<Integer> topologicalSort(int[][] edges, int n) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> topologicalSort = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int[] edge : edges)
            dfs(edge[0], adj, topologicalSort, visited);
        Collections.reverse(topologicalSort);
        return topologicalSort;
    }

    private void dfs(int source, Map<Integer, List<Integer>> adj, List<Integer> topologicalSort, Set<Integer> visited) {
        if(visited.contains(source))
            return;
        visited.add(source);
        for(Integer child : adj.get(source)) {
            dfs(child, adj, topologicalSort, visited);
        }
        topologicalSort.add(source);
    }

    public static void main(String[] args) {
        TopologicalSort sort = new TopologicalSort();
        int[][] edges = new int[][] {{1, 2},
                                     {1, 3},
                                     {2, 4},
                                     {3, 5},
                                     {4, 6},
                                     {5, 6},
                                     {9, 10}};
        List<Integer> topSort = sort.topologicalSort(edges, 10);
        System.out.println("Topological Sort: " + topSort);
        /*for(int num : topSort)
            System.out.println(num);*/ // 1, 2, 3, 4, 5, 6, 9, 10 or 9, 10, 1, 3, 5, 2, 4, 6, etc there can be multiple valid ordering of elements
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a directed acyclical graph, return a valid topological ordering of the graph

            1                  9
        /       \              |
      2          3             |
      |          |            10
      4          5
        \      /
            6
 */
