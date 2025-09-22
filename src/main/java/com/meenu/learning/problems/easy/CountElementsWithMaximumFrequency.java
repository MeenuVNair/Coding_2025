package com.meenu.learning.problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 22/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(k)
    freqMap stores counts for k unique elements → O(k)
 */

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = -1;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > maxFreq)
                maxFreq = entry.getValue();
        }

        int freqCount = 0;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() == maxFreq) {
                freqCount += entry.getValue();
            }
        }
        return freqCount;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an array nums consisting of positive integers.

 Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

 The frequency of an element is the number of occurrences of that element in the array.



 Example 1:

 Input: nums = [1,2,2,3,1,4]
 Output: 4
 Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
 So the number of elements in the array with maximum frequency is 4.
 Example 2:

 Input: nums = [1,2,3,4,5]
 Output: 5
 Explanation: All elements of the array have a frequency of 1 which is the maximum.
 So the number of elements in the array with maximum frequency is 5.


 Constraints:

 1 <= nums.length <= 100
 1 <= nums[i] <= 100

 Hint 1
 Find frequencies of all elements of the array.
 Hint 2
 Find the elements that have the maximum frequencies and count their total occurrences.
 */
