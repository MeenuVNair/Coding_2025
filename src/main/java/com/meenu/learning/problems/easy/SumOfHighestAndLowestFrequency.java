package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
Initialize min with array.length and max with 0
 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because the code iterates through the input array once to build the frequency map and then iterates through the map, which in the worst case can have n distinct elements, hence O(n + n) which simplifies to O(n).
 Space Complexity:O(n) because, in the worst-case scenario, the frequency map might store the frequency of each distinct element in the input array, which could be n.
 */

public class SumOfHighestAndLowestFrequency {
    public int sumHighestAndLowestFrequency(int[] nums) {
        if (nums.length == 1) {
            return 2;
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int[] minMaxArray = new int[]{nums.length, 0};
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minMaxArray[0] = Math.min(minMaxArray[0], entry.getValue());
            minMaxArray[1] = Math.max(minMaxArray[1], entry.getValue());
        }
        return minMaxArray[0] + minMaxArray[1];
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of n integers, find the sum of the frequencies of the highest occurring number and lowest occurring number.


 Examples:
 Input: arr = [1, 2, 2, 3, 3, 3]

 Output: 4

 Explanation: The highest frequency is 3 (element 3), and the lowest frequency is 1 (element 1). Their sum is 3 + 1 = 4.

 Input: arr = [4, 4, 5, 5, 6]

 Output: 3

 Explanation: The highest frequency is 2 (elements 4 and 5), and the lowest frequency is 1 (element 6). Their sum is 2 + 1 = 3.

 Input: arr = [10, 9, 7, 7, 8, 8, 8]

 Output:
 4
 5
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= n <= 105
 1 <= arr[i] <= 104
 */
