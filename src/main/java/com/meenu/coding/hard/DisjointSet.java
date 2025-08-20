package com.meenu.coding.hard;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 
 Union Disjoint Sets
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:The time complexity is amortized O(alpha(n)) for find and union operations, where alpha(n) is the inverse Ackermann function, which grows very slowly and can be considered nearly constant for practical input sizes.
                The constructor has a time complexity of O(n) due to the initialization loop.
 Space Complexity:The space complexity is O(n) due to the parent, rank and size arrays.
 */

public class DisjointSet {
    int[] parent;
    int[] rank;
    int[] size;
    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        size = new int[n + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }


    public boolean find(int u, int v) {
        if(findRoot(u) == findRoot(v))
            return true;
        return false;
    }

    public int findRoot(int n) {
        int p = parent[n];
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public void unionByRank(int u, int v) {
        int p1 = findRoot(u);
        int p2 = findRoot(v);
        if(p1 == p2)
            return;
        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if(rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }
    }

    public void unionBySize(int u, int v) {
        int p1 = findRoot(u);
        int p2 = findRoot(v);
        if(p1 == p2)
            return;
        if(size[p1] > size[p2]) {
            parent[p2] = p1;
            size[p1] += p2;
        } else {
            parent[p1] = p2;
            size[p2] += p1;
        }
        return;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Disjoint Set


 0

 100
 Hard


 Design a disjoint set (also called union-find) data structure that supports the following operations:



 DisjointSet(int n) initializes the disjoint set with n elements.

 void unionByRank(int u, int v) merges the sets containing u and v using the rank heuristic.

 void unionBySize(int u, int v) merges the sets containing u and v using the size heuristic.

 bool find(int u, int v) checks if the elements u and v are in the same set and returns true if they are, otherwise false.


 Examples:
 Input:

 ["DisjointSet", "unionByRank", "unionBySize", "find", "find"]

 [[5], [0, 1], [2, 3], [0, 1], [0, 3]]



 Output:

 [null, null, null, true, false]



 Explanation:

 DisjointSet ds = new DisjointSet(5); // Initialize a disjoint set with 5 elements

 ds.unionByRank(0, 1); // Merge sets containing 0 and 1 using rank

 ds.unionBySize(2, 3); // Merge sets containing 2 and 3 using size

 ds.find(0, 1); // Returns true as 0 and 1 are in the same set

 ds.find(0, 3); // Returns false as 0 and 3 are not in the same set

 Input:

 ["DisjointSet", "unionBySize", "unionBySize", "find", "find"]

 [[3], [0, 1], [1, 2], [0, 2], [0, 1]]



 Output:

 [null, null, null, true, true]



 Explanation:

 DisjointSet ds = new DisjointSet(3); // Initialize a disjoint set with 3 elements

 ds.unionBySize(0, 1); // Merge sets containing 0 and 1 using size

 ds.unionBySize(1, 2); // Merge sets containing 1 and 2 using rank

 ds.find(0, 2); // Returns true as 0 and 2 are in the same set

 ds.find(0, 1); // Returns true as 0 and 1 are in the same set

 Input:

 ["DisjointSet", "unionByRank", "unionBySize", "unionByRank", "find", "find"]

 [[5], [0, 1], [3, 4], [1, 2], [0, 2], [1, 3]]

 Output:
 [null, null, null, null, false, false]
 [null, null, null, null, true, true]
 [null, null, null, null, true, false]
 [null, null, null, null, false, true]

 Submit
 Constraints:
 1 <= n <= 104
 0 <= u, v < n
 At most 5 * 104 calls will be made to unionByRank, unionBySize, and find

 Hint 1
 When calling find(), update the parent pointer to the root, making future lookups O(1).

 Hint 2
 "Attach the smaller height tree to the larger height tree to keep the structure balanced. Attach the smaller set to the larger set to keep set sizes balanced."
 */
