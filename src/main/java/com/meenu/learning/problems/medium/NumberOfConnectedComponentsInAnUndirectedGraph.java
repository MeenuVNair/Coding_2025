package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 

 Implements the Union-Find algorithm

 - We create an object of the Disjoint Union Set and initialize the result variable res = n, which indicates that there are n components initially.
 - We then iterate through the given edges.
 - For each edge, we attempt to connect the nodes using the union function of the DSU.
 - If the union is successful, we decrement res; otherwise, we continue.
 - Finally, we return res as the number of components.

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(E * α(V)) where E is the number of edges, V is the number of vertices, and α(V) is the inverse Ackermann function which grows very slowly, practically constant.
 Space Complexity:O(V) due to the parent and rank arrays in the UnionFind data structure.
 */

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n) {
            int p = parent[n];
            while(p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

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
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int result = n;
        for(int[] edge : edges) {
            if(uf.union(edge[0], edge[1]))
                result--;
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.

 The nodes are numbered from 0 to n - 1.

 Return the total number of connected components in that graph.

 Example 1:

 Input:
 n=3
 edges=[[0,1], [0,2]]

 Output:
 1
 Example 2:

 Input:
 n=6
 edges=[[0,1], [1,2], [2,3], [4,5]]

 Output:
 2
 Constraints:

 1 <= n <= 100
 0 <= edges.length <= n * (n - 1) / 2


 Recommended Time & Space Complexity
 You should aim for a solution as good or better than O(V + E) time and O(V + E) space, where V is the number vertices and E is the number of edges in the graph.


 Hint 1
 Assume there are no edges initially, so we have n components, as there are that many nodes given. Now, we should add the given edges between the nodes. Can you think of an algorithm to add the edges between the nodes? Also, after adding an edge, how do you determine the number of components left?


 Hint 2
 We can use the Union-Find (DSU) algorithm to add the given edges. For simplicity, we use Union-Find by size, where we merge the smaller component into the larger one. The Union-Find algorithm inserts the edge only between two nodes from different components. It does not add the edge if the nodes are from the same component. How do you find the number of components after adding the edges? For example, consider that nodes 0 and 1 are not connected, so there are initially two components. After adding an edge between these nodes, they become part of the same component, leaving us with one component.


 Hint 3
 We create an object of the DSU and initialize the result variable res = n, which indicates that there are n components initially. We then iterate through the given edges. For each edge, we attempt to connect the nodes using the union function of the DSU. If the union is successful, we decrement res; otherwise, we continue. Finally, we return res as the number of components.
 */
