package com.meenu.learning.util;


/**
 * @author Meenu V. Nair
 * @created 27/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : 
 Space Complexity : 
 */

public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
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
        } else if(rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
