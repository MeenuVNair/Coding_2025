package com.meenu.learning.algorithms;

import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 02/09/25
 */

/*******  APPROACH ******************** 
 In 0/1 Knapsack, we were only allowed to include each item at most once.
 With the unbounded knapsack, we have no limit on how many times we can include an item.

 Here as well we are trying to maximize our total profit by choosing items such that our capacity remains >=0.
 Since we can include a given item multiple times, our decision tree's height will end up being m, where m is the total capacity.
 This is different compared to the 0/1 where the height of our decision tree was n, where n was the length of the profit and weight array.

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n * m)
 Space Complexity : O(n * m)
 where n is the number of items & m is the capacity
 */

public class UnboundedKnapsack_Memoization {
    public int knapsack(List<Integer> profit, List<Integer> weight, int capacity) {
        int[][] cache = new int[profit.size()][capacity + 1];
        for(int i = 0; i < profit.size(); i++) {
            for(int j = 0; j <= capacity; j++) {
                cache[i][j] = Integer.MIN_VALUE;
            }
        }
        return dfs(0, profit, weight, capacity, cache);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity, int[][] cache) {
        if(i == profit.size())
            return 0;
        if(cache[i][capacity] != Integer.MIN_VALUE)
            return cache[i][capacity];

        // skip the item
        cache[i][capacity] = dfs(i + 1, profit, weight, capacity, cache);

        // include the item
        int newCapacity = capacity - weight.get(i);
        if(newCapacity >= 0) {
            int newProfit = profit.get(i) + dfs(i, profit, weight, newCapacity, cache);
            cache[i][capacity] = Math.max(newProfit, cache[i][capacity]);
        }
        return cache[i][capacity];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a list of N items, and a backpack with a limited capacity, return the maximum total profit that can be contained in the backpack.
 The i-th item's profit is profit[i] and its weight is weight[i].
 Assume you can have an unlimited number of each item available
 */
