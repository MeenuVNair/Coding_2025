package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n) due to iterating through the input array once.
 Space Complexity:O(1) as it uses a constant amount of extra space.
 */

public class LargestElement {
    public int largestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        for(int num : nums) {
            largest = Math.max(largest, num);
        }
        return largest;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers nums, return the value of the largest element in the array


 Examples:
 Input: nums = [3, 3, 6, 1]

 Output: 6

 Explanation: The largest element in array is 6

 Input: nums = [3, 3, 0, 99, -40]

 Output: 99

 Explanation: The largest element in array is 99

 Input: nums = [-4, -3, 0, 1, -8]

 Output:
 3
 5
 1
 4
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 nums may contain duplicate elements.
 */
