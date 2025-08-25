package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 23/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

/******** TIME LIMIT EXCEEDED ************/

public class CombinationSum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void findCombinations(int i, int[] candidates, int curSum, int target, List<Integer> curComb, List<List<Integer>> result) {
        if(target == curSum) {
            result.add(new ArrayList<>(curComb));
            return;
        }
        if(i >= candidates.length)
            return;

        while(i + 1 < candidates.length && candidates[i] == candidates[i + 1])
            i++;
        if(candidates[i] > target)
            return;
        curComb.add(candidates[i]);
        findCombinations(i + 1, candidates, curSum + candidates[i], target, curComb, result);
        curComb.remove(curComb.size() - 1);
        findCombinations(i + 1, candidates, curSum, target, curComb, result);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given collection of candidate numbers (candidates) and a integer target.Find all unique combinations in candidates where the sum is equal to the target.There can only be one usage of each number in the candidates combination and return the answer in sorted order.



 e.g : The combination [1, 1, 2] and [1, 2, 1] are not unique.


 Examples:
 Input : candidates = [2, 1, 2, 7, 6, 1, 5] , target = 8

 Output : [ [1, 1, 6] , [1, 2, 5] , [1, 7] , [2, 6] ]

 Explanation : The combinations sum up to target are

 1 + 1 + 6 => 8.

 1 + 2 + 5 => 8.

 1 + 7 => 8.

 2 + 6 => 8.

 Input : candidates = [2, 5, 2, 1, 2] , target = 5

 Output : [ [1, 2, 2] , [5] ]

 Explanation : The combinations sum up to target are

 1 + 2 + 2 => 5.

 5 => 5.

 Input : candidates = [2, 1, 2] , target = 5

 Output:
 [ [2, 1, 2] ]
 [ [1, 2, 2] ]
 [ [1, 1, 1, 1, 1] ]
 [ [2, 1, 1, 1] ]

 Submit
 Constraints:
 1 <= candidates.length <= 100
 1 <= candidates[i] <= 50
 1 <= target <= 30

 Similar Problems

 Hint 1
 Use recursion to explore all possible combinations. Stop when the target becomes zero (a valid combination is found) or when the target becomes negative (discard the branch).

 Hint 2
 "Sort the input array candidates to handle duplicates easily. Skip duplicates during recursion: If candidates[i]==candidates[i-1] and i>start, skip the current element."
 */
