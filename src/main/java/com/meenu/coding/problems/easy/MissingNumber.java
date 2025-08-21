package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 03/08/25
 */

/*******  APPROACH ******************** 
 We will first calculate the summation of first N natural numbers(i.e. 1 to N) using the formula (N*(N+1))/2 .
 Then we will add all the array elements using a loop.
 Finally, we will consider the difference between the summation of the first N natural numbers and the sum of the array elements.
 */

/**
 Time Complexity:The time complexity is O(n) because the code iterates through the input array once.
 Space Complexity:The space complexity is O(1) because the code uses a constant amount of extra space.
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNNumbers = (n * (n + 1)) / 2;
        int sumOfNumbersInArray = 0;
        for(int i = 0; i < n; i++) {
            sumOfNumbersInArray += nums[i];
        }

        return sumOfNNumbers - sumOfNumbersInArray;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



 Example 1:

 Input: nums = [3,0,1]

 Output: 2

 Explanation:

 n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

 Example 2:

 Input: nums = [0,1]

 Output: 2

 Explanation:

 n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

 Example 3:

 Input: nums = [9,6,4,2,3,5,7,0,1]

 Output: 8

 Explanation:

 n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.








 Constraints:

 n == nums.length
 1 <= n <= 104
 0 <= nums[i] <= n
 All the numbers of nums are unique.


 Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
