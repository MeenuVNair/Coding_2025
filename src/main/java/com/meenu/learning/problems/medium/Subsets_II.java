package com.meenu.learning.problems.medium;


import java.util.ArrayList;
import java.util.Arrays;
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

 Here input contains duplicates, so to create concrete subsets, we first sort the array so all duplicates are adjacent to one another.
 We can then run a while loop to skip over the duplicates.
 This is different than the previous problem because in this case, when we backtrack, i.e. pop from the curSet, we run a while loop to skip over the duplicates before calling finSubsets again.
 We also make sure that our i pointer does not go out of bounds.

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(2^n) due to the recursive calls exploring all possible subsets, with additional O(n log n) for sorting.
 Space Complexity:O(n) primarily due to the depth of the recursion stack and the space used by curSet, where n is the number of elements in nums.
 */

public class Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> curSet = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, curSet, subsets);
        return subsets;
    }

    private void findSubsets(int i, int[] nums, List<Integer> curSet, List<List<Integer>> subsets) {
        if(i >= nums.length) {
            subsets.add(new ArrayList<>(curSet));
            return;
        }
        curSet.add(nums[i]); // finding subset by including current element
        findSubsets(i + 1, nums, curSet, subsets);
        curSet.remove(curSet.size() - 1); // finding subset by not including current element
        while(i + 1 < nums.length && nums[i] == nums[i + 1]) // remove all the duplicated, as we sorted the array, duplicates will be adjacent
            i++;
        findSubsets(i + 1, nums, curSet, subsets);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

 The solution set must not contain duplicate subsets. Return the solution in any order.


 Example 1:

 Input: nums = [1,2,2]
 Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 Example 2:

 Input: nums = [0]
 Output: [[],[0]]

 Constraints:

 1 <= nums.length <= 10
 -10 <= nums[i] <= 10
 */
