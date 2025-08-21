package com.meenu.coding.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************

 Time Complexity:O(m * alpha(n)) where m is the number of edges and alpha(n) is the inverse Ackermann function, practically a constant.
                Initializing DisjointSet takes O(n), union and find operations take O(alpha(n)) each, and iterating through edges takes O(m), the loop to find number of components take O(n).
 Space Complexity:O(n) due to the parent and rank arrays in the DisjointSet data structure.

 */

public class NumberOfOperationsToMakeNetworkConnected {
    class DisjointSet {
        int[] parent;
        int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n) {
            if(n == parent[n])
                return n;
            return parent[n] = find(parent[n]);
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

    public int solve(int n, int[][] Edge) {

        if(n - 1 > Edge.length) //Return -1 if connecting all vertices is not possible
            return -1;

        DisjointSet ds = new DisjointSet(n);

        // Add all the edges in the set
        for(int[] edge : Edge) {
            ds.union(edge[0], edge[1]);
        }

        // To store count of required edges
        int count = 0;
        // Finding the number of components
        for(int i = 0; i < n; i++) {
            if(ds.parent[i] == i)
                count++;
        }
        return count - 1; // Return the result
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a graph with n vertices and m edges. The graph is represented by an array Edges, where Edge[i] = [a, b] indicates an edge between vertices a and b. One edge can be removed from anywhere and added between any two vertices in one operation. Find the minimum number of operations that will be required to make the graph connected. If it is not possible to make the graph connected, return -1.

 Examples:
 Input : n = 4, Edge =[ [0, 1], [ 0, 2], [1, 2]]

 Output: 1

 Explanation: We need a minimum of 1 operation to make the two components connected. We can remove the edge (1,2) and add the edge between node 2 and node 3 like the following:

 Input: n = 9, Edge = [[0,1],[0,2],[0,3],[1,2],[2,3],[4,5],[5,6],[7,8]]

 Output: 2

 Explanation: We need a minimum of 2 operations to make the two components connected. We can remove the edge (0,2) and add the edge between node 3 and node 4 and we can remove the edge (0,3) and add it between nodes 6 and 8 like the following:

 Input: n = 4, Edge =[[0, 1]]

 Output:
 0
 3
 4
 -1
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= n <= 104
 1 <= Edge.length <= 104
 Edge[i].length == 2

 Hint 1
 "The problem can be solved using Disjoint Set Union (DSU) / Union-Find: Find the number of connected components. If we have c components, at least c-1 edge moves are needed to connect them."

 Hint 2
 "Initialize a Union-Find data structure for n nodes. Union all edges and track the number of connected components. Count the number of extra edges that can be moved. If the number of extra edges is at least c-1, return c-1; otherwise, return -1."
 */
