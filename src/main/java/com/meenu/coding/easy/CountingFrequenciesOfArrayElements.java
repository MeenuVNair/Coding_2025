package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) due to iterating through the input array once and iterating through the HashMap which will have atmost n entries, the total time complexity will be O(n)+O(n) which is O(n).
 Space Complexity:O(n) because the HashMap `freqMap` can store up to n distinct elements in the worst case, and `freqList` can also store up to n elements.
 */

public class CountingFrequenciesOfArrayElements {
    public List<List<Integer>> countFrequencies(int[] nums) {
        if(nums.length == 1) {
            List<Integer> freq = new ArrayList<>();
            freq.add(nums[0]);
            freq.add(1);
            List<List<Integer>> result = new ArrayList<>();
            result.add(freq);
            return result;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<List<Integer>> freqList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            List<Integer> currFreq = new ArrayList<>();
            currFreq.add(entry.getKey());
            currFreq.add(entry.getValue());
            freqList.add(currFreq);
        }
        return freqList;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array nums of size n which may contain duplicate elements, return a list of pairs where each pair contains a unique element from the array and its frequency in the array.



 You may return the result in any order, but each element must appear exactly once in the output.


 Examples:
 Input: nums = [1, 2, 2, 1, 3]

 Output: [[1, 2], [2, 2], [3, 1]]

 Explanation:

 - 1 appears 2 times

 - 2 appears 2 times

 - 3 appears 1 time

 Order of output can vary.

 Input: nums = [5, 5, 5, 5]

 Output: [[5, 4]]

 Explanation:

 - 5 appears 4 times.

 Input: nums = [7]

 Output:
 [[7, 1]]
 [[1, 7]]
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= nums.length <= 105
 -109 <= nums[i] <= 109
 */
