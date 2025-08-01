package com.meenu.coding.easy;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

/**
 Time Complexity:O(n) because the code iterates through the input array `nums` once in the worst-case scenario.
 Space Complexity:O(n) because, in the worst-case scenario, the HashMap `map` could store all the elements of the input array `nums`.
 */

// ******** BRUTE FORCE ************* //
/*public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}*/

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                int second = map.get(target - nums[i]);
                res[0] = i;
                res[1] = second;
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}

/**
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.



 Example 1:

 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 Example 2:

 Input: nums = [3,2,4], target = 6
 Output: [1,2]
 Example 3:

 Input: nums = [3,3], target = 6
 Output: [0,1]


 Constraints:

 2 <= nums.length <= 104
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 Only one valid answer exists.


 Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
