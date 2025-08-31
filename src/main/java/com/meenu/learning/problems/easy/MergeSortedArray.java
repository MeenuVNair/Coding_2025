package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 31/08/25
 */

/*******  APPROACH ******************** 
with a new array
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(m + n)
 Space Complexity : O(n + m)
 */

/******** Bruteforce with extra space ****************/
// but problem asks to modify the 1st array itself

/*public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        while(i < m && j < n) {
            if(nums1[i] <= nums2[j]) {
                merged[index++] = nums1[i];
                i++;
            } else {
                merged[index++] = nums2[j];
                j++;
            }
        }
        if(i < m) {
            while(i < m) {
                merged[index++] = nums1[i++];
            }
        }
        if(j < n) {
            while(j < n) {
                merged[index++] = nums2[j++];
            }
        }

        for(i = 0; i < m + n; i++) {
            nums1[i] = merged[i];
        }
    }
}*/

/*******  APPROACH ********************
 without new array
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(m + n)
 Space Complexity : O(1)
 */



public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // last index of nums1's valid part
        int j = n - 1; // last index of nums2
        int k = m + n - 1; // last index of nums1 total space

        // Merge from the back
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has remaining elements
        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        MergeSortedArray obj = new MergeSortedArray();
        /*int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        obj.merge(nums1, 3, nums2,  3);*/ // 1, 2, 2, 3, 5, 6

        /*int[] nums1 = new int[] {1};
        int[] nums2 = new int[] {};
        obj.merge(nums1, 1, nums2,  0);*/ // 1

        /*int[] nums1 = new int[] {0};
        int[] nums2 = new int[] {1};
        obj.merge(nums1, 0, nums2,  1);*/ // 1

        int[] nums1 = new int[] {4,5,6,0,0,0};
        int[] nums2 = new int[] {1,2,3};
        obj.merge(nums1, 3, nums2,  3);

        for(int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

 Merge nums1 and nums2 into a single array sorted in non-decreasing order.

 The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



 Example 1:

 Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 Output: [1,2,2,3,5,6]
 Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 Example 2:

 Input: nums1 = [1], m = 1, nums2 = [], n = 0
 Output: [1]
 Explanation: The arrays we are merging are [1] and [].
 The result of the merge is [1].
 Example 3:

 Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 Output: [1]
 Explanation: The arrays we are merging are [] and [1].
 The result of the merge is [1].
 Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.


 Constraints:

 nums1.length == m + n
 nums2.length == n
 0 <= m, n <= 200
 1 <= m + n <= 200
 -109 <= nums1[i], nums2[j] <= 109


 Follow up: Can you come up with an algorithm that runs in O(m + n) time?

 */
