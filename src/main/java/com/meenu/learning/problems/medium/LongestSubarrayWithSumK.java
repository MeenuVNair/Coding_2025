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
 Time Complexity:The time complexity is O(n) because the code iterates through the input array 'nums' once.
 Space Complexity:The space complexity is O(n) because the HashMap 'map' can store up to n key-value pairs in the worst case.
 */

public class LongestSubarrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        int currSum = 0;
        for(int i = 0; i < nums.length; i++) {
            //calculate the sum till index i:
            currSum += nums[i];
            // if the currSum = k, update the maxLength:
            if(currSum == k)
                maxLength = Math.max(maxLength, i + 1);

            // calculate the sum of remaining part i.e. x-k:
            int diff = currSum - k;

            //Calculate the length and update maxLength:
            if(map.containsKey(diff)) {
                maxLength = Math.max(maxLength, (i - map.get(diff)));
            }

            //Finally, update the map checking the conditions:
            if(!map.containsKey(currSum)) {
                map.put(currSum , i);
            }
        }
        return maxLength;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.


 Examples:
 Input: nums = [10, 5, 2, 7, 1, 9],  k=15

 Output: 4

 Explanation:

 The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

 Input: nums = [-3, 2, 1], k=6

 Output: 0

 Explanation:

 There is no sub-array in the array that sums to 6. Therefore, the output is 0.

 Input: nums = [-1, 1, 1], k=1

 Output:
 2
 4
 3
 1
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1<=n<=105
 -105<=nums[i]<=105
 -109<= k<=109

 Hint 1
 Use a hash map to store the prefix sum of the array at each index. This helps efficiently track subarrays that sum to k.

 Hint 2
 For each index i, calculate the prefix sum up to that point. If the prefix sum minus k exists in the hash map, the subarray between those indices sums to k.
 */
