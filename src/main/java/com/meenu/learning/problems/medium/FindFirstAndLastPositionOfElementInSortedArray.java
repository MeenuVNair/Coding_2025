package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 25/08/25
 */

/*******  APPROACH ******************** 
 Done this on O(n)
 But the problem asks for O(log n) --> Binary search
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */


/*public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        Map<Integer, List<Integer>> indicesMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(indicesMap.containsKey(nums[i])) {
                List<Integer> indices = indicesMap.get(nums[i]);
                indices.add(i);
                indicesMap.put(nums[i], indices);
            } else {
                List<Integer> index = new ArrayList<>();
                index.add(i);
                indicesMap.put(nums[i], index);
            }
        }
        int first = -1, last = -1;
        if(indicesMap.containsKey(target)) {
            List<Integer> indices = indicesMap.get(target);
            for(int num : indices)
                System.out.print(num + ", ");
            first = indices.get(0);
            last = indices.get(indices.size() - 1);
        }

        return new int[] {first, last};
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] input = new int[] {5,7,7,8,8,10};
        obj.searchRange(input, 8);
    }
}*/


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(log n)
 Space Complexity : O(log n)
 */

/*********** BINARY SEARCH *******************/


public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int firstIndex = findFirst(nums, target);
        int lastIndex = findLast(nums, target);
        return new int[] {firstIndex, lastIndex};
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] >= target)
                r = mid - 1;
            else
                l = mid + 1;
            if(nums[mid] == target)
                index = mid;
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
            if(nums[mid] == target)
                index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray obj = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] input = new int[] {5,7,7,8,8,10};
        int[] output = obj.searchRange(input, 8);
        System.out.println("[" + output[0] + "," + output[1] + "]");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 Example 3:

 Input: nums = [], target = 0
 Output: [-1,-1]


 Constraints:

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109
 nums is a non-decreasing array.
 -109 <= target <= 109
 */
