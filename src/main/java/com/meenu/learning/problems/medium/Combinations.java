package com.meenu.learning.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 23/08/25
 */

/*******  APPROACH ******************** 
 input size = 1 <= n <= 20, hence exponential solution is acceptable
 so we can try with all possible solutions, which will be 2^n and that would be acceptable
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(k * 2^n) -- Given n numbers (1 - n), return all possible combinations of size k. (n choose k math problem).
         2^n → exploring all possible choices.
         k → cost of writing down each combination when you find it

 Space Complexity (excluding result): O(n + k)
 (recursion stack + temporary path).
 Total Space (including result): O(k * C(n, k)).
 */

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombs = new ArrayList<>();
        findCombinations(1, allCombs, new ArrayList<>(), n, k);
        return allCombs;
    }

    private void findCombinations(int currNum, List<List<Integer>> allCombs, List<Integer> curCombs, int n, int k) {
        if(curCombs.size() == k) {
            allCombs.add(new ArrayList<>(curCombs));
            return;
        }
        if(currNum > n)
            return;
        curCombs.add(currNum);
        findCombinations(currNum + 1, allCombs, curCombs, n, k);
        curCombs.remove(curCombs.size() - 1);
        findCombinations(currNum + 1, allCombs,curCombs, n, k);
    }
}

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(k * C(n, k)) -- Given n numbers (1 - n), return all possible combinations of size k. (n choose k math problem).

 Space Complexity :
 Auxiliary Space Complexity (excluding output): O(k)
 Total Space Complexity (including output): O(k * C(n, k))
 */

/********** SLIGHTLY BETTER APPROACH (the above one is also fine) ********/

/*public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allCombs = new ArrayList<>();
        findCombinations(1, allCombs, new ArrayList<>(), n, k);
        return allCombs;
    }

    private void findCombinations(int curNum, List<List<Integer>> allCombs, List<Integer> curCombs, int n, int k) {
        if(curCombs.size() == k) {
            allCombs.add(new ArrayList<>(curCombs));
            return;
        }
        if(curNum > n)
            return;
        for(int j = curNum; j <= n; j++) {
            curCombs.add(j);
            findCombinations(j + 1, allCombs, curCombs, n, k);
            curCombs.remove(curCombs.size() - 1);
        }
    }
}*/

/*******  PROBLEM DESCRIPTION ******************** 
 Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

 You may return the answer in any order.

 Example 1:

 Input: n = 4, k = 2
 Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 Explanation: There are 4 choose 2 = 6 total combinations.
 Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 Example 2:

 Input: n = 1, k = 1
 Output: [[1]]
 Explanation: There is 1 choose 1 = 1 total combination.


 Constraints:

 1 <= n <= 20
 1 <= k <= n
 */
