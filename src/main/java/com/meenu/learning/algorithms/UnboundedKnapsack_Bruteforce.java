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
 Time Complexity : O(2^n)
 Space Complexity : O(n)
 where n is the number of items
 */

public class UnboundedKnapsack_Bruteforce {
    public int dfs(List<Integer> profit, List<Integer> weight, int capacity) {
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
            int newProfit = profit.get(i) + dfs(i, profit, weight, newCapacity);
            maxProfit = Math.max(newProfit, maxProfit);
        }
        return maxProfit;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a list of N items, and a backpack with a limited capacity, return the maximum total profit that can be contained in the backpack.
 The i-th item's profit is profit[i] and its weight is weight[i].
 Assume you can have an unlimited number of each item available
 */
