package com.meenu.learning.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 16/08/25
 */

/*******  APPROACH ******************** 
 Prefix Sum
 */


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int currSum = 0;
        map.put(0, 1);
        for(int num : nums) {
            currSum += num;
            int diff = currSum - k;
            result += map.getOrDefault(diff, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

 A subarray is a contiguous non-empty sequence of elements within an array.

 Example 1:

 Input: nums = [1,1,1], k = 2
 Output: 2
 Example 2:

 Input: nums = [1,2,3], k = 3
 Output: 2


 Constraints:

 1 <= nums.length <= 2 * 104
 -1000 <= nums[i] <= 1000
 -107 <= k <= 107

 Hint 1
 Will Brute force work here? Try to optimize it.
 Hint 2
 Can we optimize it by using some extra space?
 Hint 3
 What about storing sum frequencies in a hash table? Will it be useful?
 Hint 4
 sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
 */
