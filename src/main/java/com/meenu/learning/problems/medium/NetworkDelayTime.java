package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 26/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E logE)
 Space Complexity : O(E + V)
 */

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 1; i < n + 1; i++) {
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge : times) {
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        }

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1, n2) -> n1[0] - n2[0]);
        minHeap.add(new int[] {0, k});
        int t = 0;
        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.remove();
            int n1 = curr[1], w1 = curr[0];
            if(visited.contains(n1))
                continue;
            visited.add(n1);
            t = Math.max(t, w1);
            for(int[] pair : adj.get(n1)) {
                int n2 = pair[0], w2 = pair[1];
                if(!visited.contains(n2))
                    minHeap.add(new int[] {w1 + w2, n2});
            }
        }
        return visited.size() == n ? t : -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

 We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.



 Example 1:


 Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 Output: 2
 Example 2:

 Input: times = [[1,2,1]], n = 2, k = 1
 Output: 1
 Example 3:

 Input: times = [[1,2,1]], n = 2, k = 2
 Output: -1


 Constraints:

 1 <= k <= n <= 100
 1 <= times.length <= 6000
 times[i].length == 3
 1 <= ui, vi <= n
 ui != vi
 0 <= wi <= 100
 All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

 Hint 1
 We visit each node at some time, and if that time is better than the fastest time we've reached this node, we travel along outgoing edges in sorted order. Alternatively, we could use Dijkstra's algorithm.
 */
