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
 Time Complexity:The time complexity is O(n) because the code iterates through the input array once.
 Space Complexity:The space complexity is O(n) in the worst case, as the HashMap 'map' might store all prefix sums if they are unique.
 */

public class LargestSubarrayWithSum0 {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum == 0) {
                maxLength = Math.max(maxLength, i + 1);
            }

            if(map.containsKey(currSum)) {
                maxLength = Math.max(maxLength, i - map.get(currSum));
            } else {
                map.put(currSum, i);
            }
        }

        return maxLength;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer array arr of size n which contains both positive and negative integers. Your task is to find the length of the longest contiguous subarray with sum equal to 0.

 Return the length of such a subarray. If no such subarray exists, return 0.

 Examples:
 Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]

 Output: 5

 Explanation:

 The subarray [-2, 2, -8, 1, 7] sums up to 0 and has the maximum length among all such subarrays.

 Input: arr = [2, 10, 4]

 Output: 0

 Explanation:

 There is no subarray whose elements sum to 0.

 Constraints:
 1 <= arr.length <= 106
 -103 <= arr[i] <= 103 for each valid index i

 Hint 1
 Try using prefix sums. Keeping a running sum as you traverse the array allows you to relate distant elements and identify when a subarray sums to 0.

 Hint 2
 Use a hash map (or dictionary) to store the earliest index where each prefix sum occurs. If a prefix sum repeats, the subarray between the first occurrence and the current index has a sum of 0. Update the maximum length accordingly.
 */
