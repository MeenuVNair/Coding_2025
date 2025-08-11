package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 We can use TreeMap here (as we need to return the smaller number if frequency is same for multiple elements)
 */

import java.util.Map;
import java.util.TreeMap;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n log n) due to TreeMap insertion and iteration, where n is the length of the input array nums.
 Space Complexity:O(n) in the worst case, where n is the number of unique elements in the input array nums due to storing elements in freqMap. Additionally O(1) for min array.
 */

public class HighestOccurringElementInAnArray {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for(int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int[] min = new int[2];
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() > min[1]) {
                min[0] = entry.getKey();
                min[1] = entry.getValue();
            }
        }
        return min[0];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. If there are multiple elements that appear a maximum number of times, find the smallest of them.



 Please note that this section might seem a bit difficult without prior knowledge on what hashing is, we will soon try to add basics concepts for your ease! If you know the concepts already please go ahead to give a shot to the problem. Cheers!


 Examples:
 Input: arr = [1, 2, 2, 3, 3, 3]

 Output: 3

 Explanation: The number 3 appears the most (3 times). It is the most frequent element.

 Input: arr = [4, 4, 5, 5, 6]

 Output: 4

 Explanation: Both 4 and 5 appear twice, but 4 is smaller. So, 4 is the most frequent element.

 Input: arr = [2, 4, 3, 2, 5, 4]

 Output:
 3
 2
 5
 4
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= n <= 105
 1 <= arr[i] <= 104
 */
