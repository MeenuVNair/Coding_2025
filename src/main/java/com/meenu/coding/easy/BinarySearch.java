package com.meenu.coding.easy;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;

        while(l <= r) {
            mid = (l + r) / 2;
            if(target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

/**
 *
 Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

 You must write an algorithm with O(log n) runtime complexity.



 Example 1:

 Input: nums = [-1,0,3,5,9,12], target = 9
 Output: 4
 Explanation: 9 exists in nums and its index is 4
 Example 2:

 Input: nums = [-1,0,3,5,9,12], target = 2
 Output: -1
 Explanation: 2 does not exist in nums so return -1


 Constraints:

 1 <= nums.length <= 104
 -104 < nums[i], target < 104
 All the integers in nums are unique.
 nums is sorted in ascending order.
 */
