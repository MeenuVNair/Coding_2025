package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 07/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) for the first loop, O(n) for the second loop, and O(1) for the conditional swap, resulting in O(n).
 Space Complexity:O(n) due to the hash map storing at most n elements.
 */

public class SingleNumber_III {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[2];
        int i = 0;
        while(i < 2) {
            for(int key : frequencyMap.keySet()) {
                if(frequencyMap.get(key) == 1) {
                    result[i++] = key;
                }
            }
        }
        if(result[0] > result[1]) {
            int temp = result[0];
            result[0] = result[1];
            result[1] = temp;
        }


        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Single Number - III


 0

 100
 Medium


 Given an array nums of length n, every integer in the array appears twice except for two integers. Identify and return the two integers that appear only once in the array. Return the two numbers in ascending order.



 For example, if nums = [1, 2, 1, 3, 5, 2], the correct answer is [3, 5], not [5, 3].


 Examples:
 Input : nums = [1, 2, 1, 3, 5, 2]

 Output : [3, 5]

 Explanation : The integers 3 and 5 have appeared only once.

 Input : nums = [-1, 0]

 Output : [-1, 0]

 Explanation : The integers -1 and 0 have appeared only once.

 Input : nums = [1, 9, 1, 2, 8, 2]

 Output:
 [1, 9]
 [8, 9]
 [8, 2]
 [1, 2]
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 2 <= nums.length <= 105
 -3*105 <= nums[i] <= 3*105
 Every integer in nums appears twice except two integers.
 */
