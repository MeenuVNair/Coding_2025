package com.meenu.learning.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 23/08/25
 */

/*******  APPROACH ******************** 
 Input size is very small ( 1 <= nums.length <= 10). Hence exponential solution is acceptable
 Will be using backtracking to find all possible solutions

 We build a recursive decision tree to explore all possible subsets.
 For every decision we can make, we can either include or not include the current element.
 This results in a branching factor of 2 and a height of n.

 Thus, there are roughly 2^n possible subsets.
 For each subset we create a copy of it before adding it to the final list of subsets.
 The max length a subset could be is proportional to the length of the input list nums which is n.
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n * 2^n)
 Space Complexity : O(n) , If we are not including the space needed to store the final list of subsets
 This is because we are using recursion and the space needed to store the current subset is proportional to the length of the input list nums.
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        findSubsets(0, nums, subsets, curSet);
        return subsets;
    }

    public void findSubsets(int i, int[] nums, List<List<Integer>> subsets, List<Integer> curSet) {
        if(i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]); // finding subset by including current element
        findSubsets(i + 1, nums, subsets, curSet);
        curSet.remove(curSet.size() - 1); // finding subset by not including current element
        findSubsets(i + 1, nums, subsets, curSet);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums of unique elements, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.

 Example 1:

 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]


 Constraints:

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 All the numbers of nums are unique.
 */
