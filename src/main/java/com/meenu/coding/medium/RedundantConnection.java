package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 
    Union Disjoint Sets with Path Compression and Union by size (not union by rank)
 */

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(V+(E∗α(V)))
 Space complexity: O(V)
     Where V is the number of vertices and E is the number of edges in the graph.
     α() is used for amortized complexity.
 */

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges) {
            if(!unionFind(parent, rank, edge[0], edge[1]))
                return new int[] {edge[0], edge[1]};
        }
        return new int[0];
    }

    private int find(int[] parent, int n) {
        int p = parent[n];
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean unionFind(int[] parent, int[] rank, int n1, int n2) {
        int p1 = find(parent, n1);
        int p2 = find(parent, n2);
        if(p1 == p2)
            return false;
        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }

    public static void main(String[] args) {
        RedundantConnection obj = new RedundantConnection();
        int[][] input = new int[][] {{1, 2}, {1, 3}, {3, 4}, {2, 4}, {2, 5}}; //new int[][] {{1, 2}, {1, 3}, {2, 3}};
        int[] expectedOutput = new int[] {2, 4}; //new int[] {2, 3};
        int[] actualOutput = obj.findRedundantConnection(input);
        System.out.println("Expected output : [" + expectedOutput[0] + ", " + expectedOutput[1] + "]");
        System.out.println("Actual output : [" + actualOutput[0] + ", " + actualOutput[1] + "]");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 In this problem, a tree is an undirected graph that is connected and has no cycles.

 You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

 Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

 Example 1:

 Input: edges = [[1,2],[1,3],[2,3]]
 Output: [2,3]
 Example 2:

 Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
 Output: [1,4]

 Constraints:

 n == edges.length
 3 <= n <= 1000
 edges[i].length == 2
 1 <= ai < bi <= edges.length
 ai != bi
 There are no repeated edges.
 The given graph is connected.
 */
