package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 First element should be moved to the last position and every other element should be moved one position to the left
 Copy the first element to a temporary variable
 Iterate through the array from 1 to n
 Copy every element to itz left position, ie., copy i to i - 1 (safe, as we are starting from 1)
 finally after the loop, copy the temporary variable to the last position
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n), due to the single for loop iterating through the array.
 Space Complexity:O(1), as it uses a constant amount of extra space regardless of the input size.
 */

public class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        if(nums.length == 1)
            return;
        int firstElement = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
        nums[nums.length - 1] = firstElement;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, rotate the array to the left by one.



 Note: There is no need to return anything, just modify the given array.


 Examples:
 Input: nums = [1, 2, 3, 4, 5]

 Output: [2, 3, 4, 5, 1]

 Explanation: Initially, nums = [1, 2, 3, 4, 5]

 Rotating once to left -> nums = [2, 3, 4, 5, 1]

 Input: nums = [-1, 0, 3, 6]

 Output: [0, 3, 6, -1]

 Explanation: Initially, nums = [-1, 0, 3, 6]

 Rotating once to left -> nums = [0, 3, 6, -1]

 Input: nums = [7, 6, 5, 4]

 Output:
 [5, 6, 4, 7]
 [5, 4, 7, 6]
 [6, 5, 4, 7]
 [4, 7, 6, 5]
 😕 Incorrect. Better luck next time!
 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104

 Hint 1
 Focus on moving the first element of the array to the end while shifting all other elements one position to the left.

 Hint 2
 Think about how swapping or overwriting elements can achieve the desired rotation within the same array.
 */
