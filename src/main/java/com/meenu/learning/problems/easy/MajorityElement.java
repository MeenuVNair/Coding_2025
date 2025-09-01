package com.meenu.learning.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 01/09/25
 */

/*******  APPROACH ******************** 
 HashMap to figure out frequency
 */


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(N)
 Space Complexity : O(N)
 where N is the number of elements in the input array
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int majorityValue = nums.length / 2;
        int majorityElement = -1;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > majorityValue) {
                majorityElement = entry.getKey();
            }
        }
        return majorityElement;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



 Example 1:

 Input: nums = [3,2,3]
 Output: 3
 Example 2:

 Input: nums = [2,2,1,1,1,2,2]
 Output: 2


 Constraints:

 n == nums.length
 1 <= n <= 5 * 104
 -109 <= nums[i] <= 109


 Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
