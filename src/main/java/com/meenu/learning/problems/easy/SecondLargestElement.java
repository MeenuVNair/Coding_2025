package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
 Initialise largest and secondLargest with Integer.MIN_VALUE
 Loop through the array,
    if the current number is greater than largest, update both largest and secondLargest
        secondLargest = largest
        largest = current number
    if current number is greater than secondLargest but less than largest
        then only update secondLargest

    finally, if secondLargest not equal to Integer.MIN_VALUE, then return secondLargest, else return -1
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n), single loop through the input array
 Space Complexity:O(1), uses a fixed amount of extra space
 */

public class SecondLargestElement {
    public int secondLargestElement(int[] nums) {
        if(nums.length == 1)
            return -1;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > largest) {
                secondLargest = largest;
                largest = nums[i];
            } else if(nums[i] > secondLargest && nums[i] < largest) {
                secondLargest = nums[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.


 Examples:
 Input: nums = [8, 8, 7, 6, 5]

 Output: 7

 Explanation: The largest value in nums is 8, the second largest is 7

 Input: nums = [10, 10, 10, 10, 10]

 Output: -1

 Explanation: The only value in nums is 10, so there is no second largest value, thus -1 is returned

 Input: nums = [7, 7, 2, 2, 10, 10, 10]

 Output:
 10
 2
 7
 0
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 nums may contain duplicate elements.

 Hint 1
 Use two variables to track the largest and second-largest elements as you iterate through the array. Update the second-largest only if you find an element smaller than the largest but larger than the current second-largest.

 Hint 2
 Avoid sorting, as a single traversal O(n) is sufficient to find the second-largest element.
 */
