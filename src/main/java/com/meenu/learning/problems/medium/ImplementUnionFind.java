package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 
 Union-Find is a useful tool for keeping track of nodes connected in a graph and detecting cycles in a graph.
 Of course, we can achieve this with DFS as well by using a hashset, however this is only efficient when there is a static graph.
 If we are adding edges overtime, that makes the graph dynamic, and Union-Find is a better choice.
 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity :
     By implementing union by rank and path compression, we get a time complexity of α(n),
     where α is called the Inverse Ackermann function.
     It is assumed to be constant, O(1), for nearly all input sizes.

    So, if m is the number of edges we have, then the time complexity of Union-Find is O(m ∗ α(n)) which is assumed to be O(m).

 Space Complexity :
 */

public class ImplementUnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;

    public ImplementUnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        for(int i = 1; i < n + 1; i++) {
            parent.put(i, i); // initializing node with parent, assigning node itself as its parent
            rank.put(i, 0); // initializing rank as 0 for each node
        }
    }

    // Find parent of n, with path compression.
    public int find(int n) {
        int p = parent.get(n);
        while(p != parent.get(p)) {
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }

    // Union by height / rank.
    // Return false if already connected, true otherwise.
    public boolean unionFind(int n1, int n2) {
        int p1 = this.find(n1);
        int p2 = this.find(n2);
        if(p1 == p2)
            return false;
        if(rank.get(p1) > rank.get(p2)) {
            parent.put(p2, p1);
        }
        if(rank.get(p2) > rank.get(p1)) {
            parent.put(p1, p2);
        } else {
            parent.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
Implement Union Find

 */
