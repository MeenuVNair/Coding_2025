package com.meenu.learning.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 30/08/25
 */

/*******  APPROACH ******************** 
 0/1 Knapsack - Memoization
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n * m)
 Space Complexity : O(n * m)
 Where n is the number of items & m is the capacity
 */

public class ZeroOneKnapsack_Memoization {
    public int knapsack(List<Integer> profit, List<Integer> weight, int capacity) {
        int n = profit.size();
        List<Integer[]> cache = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            cache.add(i, new Integer[capacity + 1]);
            Arrays.fill(cache.get(i), -1);;
        }
        return dfs(0, profit, weight, capacity, cache);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity, List<Integer[]> cache) {
        if(i == profit.size())
            return 0;
        if(cache.get(i)[capacity] != -1)
            return cache.get(i)[capacity];

        // skip item
        cache.get(i)[capacity] = dfs(i + 1, profit, weight, capacity, cache);

        // include item
        int newCapacity = capacity - weight.get(i);
        if(newCapacity >= 0) {
            int newProfit = profit.get(i) + dfs(i + 1, profit, weight, capacity, cache);
            cache.get(i)[capacity] = Math.max(cache.get(i)[capacity], newProfit);
        }
        return cache.get(i)[capacity];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a list of N items, and a backpack with a limited capacity, return the maximum total profit that can be contained in the backpack.
 The i-th item's profit is profit[i] and it's weight is weight[i].
 Assume you can only add each item to the bag at most one time.
 */
