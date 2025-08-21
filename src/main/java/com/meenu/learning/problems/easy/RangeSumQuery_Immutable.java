package com.meenu.learning.problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 16/08/25
 */

/*******  APPROACH ******************** 
 Prefix Sum
 */


/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(1) for each sumRange() query, O(n) for building the prefix sum array.
 Space complexity: O(n)
 */

public class RangeSumQuery_Immutable {
    List<Integer> prefix;
    public RangeSumQuery_Immutable(int[] nums) {
        prefix = new ArrayList<>();
        int total = 0;
        for(int num : nums) {
            total += num;
            prefix.add(total);
        }
    }

    public int sumRange(int left, int right) {
        int rightPrefix = prefix.get(right);
        int leftPrefix = left > 0 ? prefix.get(left - 1) : 0;
        return rightPrefix - leftPrefix;
    }

    public static void main(String args[]) {
        int[] numArray = new int[]{-2, 0, 3, -5, 2, -1};
        RangeSumQuery_Immutable obj = new RangeSumQuery_Immutable(numArray);
        int left = 0; //2; //0;
        int right = 5; //5; //2;
        int result = obj.sumRange(left, right);
        for(int i = left; i <= right; i++)
            System.out.print(obj.prefix.get(i) + " ");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, handle multiple queries of the following type:

 Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 Implement the NumArray class:

 NumArray(int[] nums) Initializes the object with the integer array nums.
 int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


 Example 1:

 Input
 ["NumArray", "sumRange", "sumRange", "sumRange"]
 [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 Output
 [null, 1, -1, -3]

 Explanation
 NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


 Constraints:

 1 <= nums.length <= 104
 -105 <= nums[i] <= 105
 0 <= left <= right < nums.length
 At most 104 calls will be made to sumRange.
 */
