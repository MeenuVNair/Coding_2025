package com.meenu.learning.problems.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Meenu V. Nair
 * @created 20/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n^2)
     Outer loop runs n times, and in the worst case, the inner loop runs up to n times.
     However, early break after matching all distinct elements optimizes the runtime in practice.

 Space Complexity : O(n)
 */

/*
public class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) unique.add(num);
        int totalDistinct = unique.size(), count = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalDistinct) {
                    count += n - j;
                    break;
                }
            }
        }

        return count;
    }
} */

/************ O(n) solution ****************/

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
    since two pointer slide at most n times.

 Space Complexity : O(n)
    for hashmap counter
 */

class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int a : nums)
            s.add(a);
        int n = nums.length, k = s.size(), res = 0, i = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int j = 0; j < n; j++) {
            if (count.getOrDefault(nums[j], 0) == 0)
                k--;
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            while (k == 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                if (count.get(nums[i]) == 0)
                    k++;
                i++;
            }
            res += i;
        }
        return res;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an array nums consisting of positive integers.

 We call a subarray of an array complete if the following condition is satisfied:

 The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
 Return the number of complete subarrays.

 A subarray is a contiguous non-empty part of an array.



 Example 1:

 Input: nums = [1,3,1,2,2]
 Output: 4
 Explanation: The complete subarrays are the following: [1,3,1,2], [1,3,1,2,2], [3,1,2] and [3,1,2,2].
 Example 2:

 Input: nums = [5,5,5,5]
 Output: 10
 Explanation: The array consists only of the integer 5, so any subarray is complete. The number of subarrays that we can choose is 10.


 Constraints:

 1 <= nums.length <= 1000
 1 <= nums[i] <= 2000

 Hint 1
 Let’s say k is the number of distinct elements in the array. Our goal is to find the number of subarrays with k distinct elements.
 Hint 2
 Since the constraints are small, you can check every subarray.

 */
