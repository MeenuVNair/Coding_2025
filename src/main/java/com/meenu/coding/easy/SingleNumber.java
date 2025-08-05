package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) due to iterating through the nums array and the map, where n is the length of the nums array.
 Space Complexity:O(n) because the HashMap 'map' can store up to n unique elements in the worst-case scenario,
 where n is the length of the nums array.
 */

/******* WITH HASHMAP *********/

/*public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int num : map.keySet()) {
            if(map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}*/

/******* WITH SET *********/

/**
 Time Complexity:The time complexity is O(n) because the code iterates through the input array 'nums' once.
 Space Complexity:The space complexity is O(n) in the worst case, where 'n' is the number of unique elements in the input array 'nums',
 because the HashSet 'set' can store up to 'n' elements.
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        for(int num : set) {
            return num;
        }
        return -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

 You must implement a solution with a linear runtime complexity and use only constant extra space.



 Example 1:

 Input: nums = [2,2,1]

 Output: 1

 Example 2:

 Input: nums = [4,1,2,1,2]

 Output: 4

 Example 3:

 Input: nums = [1]

 Output: 1



 Constraints:

 1 <= nums.length <= 3 * 104
 -3 * 104 <= nums[i] <= 3 * 104
 Each element in the array appears twice except for one element which appears only once.
 */
