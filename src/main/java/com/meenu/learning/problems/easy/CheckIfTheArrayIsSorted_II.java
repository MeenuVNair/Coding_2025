package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because the code iterates through the ArrayList once in the worst case.
 Space Complexity:O(1) because the code uses a constant amount of extra space.
 */

public class CheckIfTheArrayIsSorted_II {
    public boolean isSorted(ArrayList<Integer> nums) {
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i - 1) > nums.get(i)) {
                return false;
            }
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array nums of n integers, return true if the array nums is sorted in non-decreasing order or else false.


 Examples:
 Input : nums = [1, 2, 3, 4, 5]

 Output : true

 Explanation : For all i (1 <= i <= 4) it holds nums[i] <= nums[i+1], hence it is sorted and we return true.

 Input : nums = [1, 2, 1, 4, 5]

 Output : false

 Explanation : For i == 2 it does not hold nums[i] <= nums[i+1], hence it is not sorted and we return false.

 Input : nums = [1,9,6,8,5,4,0]

 Output:
 false
 Constraints:
 1 <= n <= 100
 1 <= nums[i] <= 100
 */
