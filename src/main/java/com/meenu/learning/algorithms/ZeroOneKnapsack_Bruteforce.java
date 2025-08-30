package com.meenu.learning.algorithms;

import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 30/08/25
 */

/*******  APPROACH ******************** 
 0/1 Knapsack - Bruteforce
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(2^n)
 Space Complexity : O(n)
 */

public class ZeroOneKnapsack_Bruteforce {
    public int knapsack(List<Integer> profit, List<Integer> weight, int capacity) {
        return dfs(0, profit, weight, capacity);
    }

    private int dfs(int i, List<Integer> profit, List<Integer> weight, int capacity) {
        if(i == profit.size())
            return 0;
        //skip the item
        int maxProfit = dfs(i + 1, profit, weight, capacity);
        //include the item
        int newCapacity = capacity - weight.get(i);
        if(newCapacity >= 0) {
            int newProfit = profit.get(i) + dfs(i + 1, profit, weight, capacity);
            maxProfit = Math.max(maxProfit, newProfit);
        }
        return maxProfit;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
  Given a list of N items, and a backpack with a limited capacity, return the maximum total profit that can be contained in the backpack.
 The i-th item's profit is profit[i] and it's weight is weight[i].
 Assume you can only add each item to the bag at most one time.
 */
