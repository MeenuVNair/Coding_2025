package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 12/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n)
 Space complexity: O(n)
 */

/** WITH PREFIX AND SUFFIX  */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}

/** BRUTE FORCE  */

/**
 Time complexity: O(n2)
 Space complexity:
    O(1) extra space.
    O(n) space for the output array.
 */

/*public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int productExceptCurrent = 1;
            for(int j = 0; j < nums.length; j++) {
                if(i == j) continue;
                productExceptCurrent *= nums[j];
            }
            result[i] = productExceptCurrent;
        }
        return result;
    }
}*/

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

 The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

 You must write an algorithm that runs in O(n) time and without using the division operation.



 Example 1:

 Input: nums = [1,2,3,4]
 Output: [24,12,8,6]
 Example 2:

 Input: nums = [-1,1,0,-3,3]
 Output: [0,0,9,0,0]


 Constraints:

 2 <= nums.length <= 105
 -30 <= nums[i] <= 30
 The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


 Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


 Seen this question in a real interview before?
 1/5
 Yes
 No
 Accepted
 3,842,680/5.7M
 Acceptance Rate
 68.0%
 Topics
 icon
 Companies
 Hint 1
 Think how you can efficiently utilize prefix and suffix products to calculate the product of all elements except self for each index. Can you pre-compute the prefix and suffix products in linear time to avoid redundant calculations?
 Hint 2
 Can you minimize additional space usage by reusing memory or modifying the input array to store intermediate results?
 */
