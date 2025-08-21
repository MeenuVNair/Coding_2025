package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 06/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:The time complexity is O(n) because the code iterates through the array `nums` twice, each time proportional to the length of the array.
 Space Complexity:The space complexity is O(1) because the algorithm uses a constant amount of extra space, regardless of the size of the input array.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Note that you must do this in-place without making a copy of the array.



 Example 1:

 Input: nums = [0,1,0,3,12]
 Output: [1,3,12,0,0]
 Example 2:

 Input: nums = [0]
 Output: [0]


 Constraints:

 1 <= nums.length <= 104
 -231 <= nums[i] <= 231 - 1


 Follow up: Could you minimize the total number of operations done?
 */
