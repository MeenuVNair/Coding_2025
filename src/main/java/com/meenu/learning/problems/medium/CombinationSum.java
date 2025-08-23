package com.meenu.learning.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 23/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(2 ^ t/m)
 Space Complexity : O(t/m)
 */

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int i, int[] candidates, int target, List<Integer> currComb, List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(currComb));
            return;
        }
        if(target < 0 || i >= candidates.length)
            return;

        currComb.add(candidates[i]);
        findCombinations(i, candidates, target - candidates[i], currComb, result);
        currComb.remove(currComb.size() - 1);
        findCombinations(i + 1, candidates, target, currComb, result);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

 The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

 The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 Example 1:

 Input: candidates = [2,3,6,7], target = 7
 Output: [[2,2,3],[7]]
 Explanation:
 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 7 is a candidate, and 7 = 7.
 These are the only two combinations.
 Example 2:

 Input: candidates = [2,3,5], target = 8
 Output: [[2,2,2,2],[2,3,3],[3,5]]
 Example 3:

 Input: candidates = [2], target = 1
 Output: []


 Constraints:

 1 <= candidates.length <= 30
 2 <= candidates[i] <= 40
 All elements of candidates are distinct.
 1 <= target <= 40


 Recommended Time & Space Complexity
 You should aim for a solution with O(2^(t/m)) time and O(t/m) space, where t is the given target and m is the minimum value in the given array.

 Hint 1
 Can you think of this problem in terms of a decision tree, where at each step, we have n decisions, where n is the size of the array? In this decision tree, we can observe that different combinations of paths are formed. Can you think of a base condition to stop extending a path? Maybe you should consider the target value.

 Hint 2
 We can use backtracking to recursively traverse these paths and make decisions to choose an element at each step. We maintain a variable sum, which represents the sum of all the elements chosen in the current path. We stop this recursive path if sum == target, and add a copy of the chosen elements to the result. How do you implement it?

 Hint 3
 We recursively traverse the array starting from index i. At each step, we select an element from i to the end of the array. We extend the recursive path with elements where sum <= target after including that element. This creates multiple recursive paths, and we append the current list to the result whenever the base condition is met.
 */
