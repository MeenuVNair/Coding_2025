package com.meenu.learning.problems.easy;

import java.util.Arrays;

/**
 * @author Meenu V. Nair
 * @created 28/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        //Sort the array first.
        Arrays.sort(nums);

        //Start traversing from back , so that we can get the largest value.
        for(int i = nums.length-1; i>1; i--){
            //Using triangle property to become valid sides
            // The sum of the length of the two sides of a triangle is greater than the length of the third side.
            if(nums[i] < nums[i-1] + nums[i-2])
                return  nums[i] + nums[i-1]+ nums[i-2];
        }

        //If we didn't found anything we return 0.
        return 0;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.



 Example 1:

 Input: nums = [2,1,2]
 Output: 5
 Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
 Example 2:

 Input: nums = [1,2,1,10]
 Output: 0
 Explanation:
 You cannot use the side lengths 1, 1, and 2 to form a triangle.
 You cannot use the side lengths 1, 1, and 10 to form a triangle.
 You cannot use the side lengths 1, 2, and 10 to form a triangle.
 As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.


 Constraints:

 3 <= nums.length <= 104
 1 <= nums[i] <= 106
 */
