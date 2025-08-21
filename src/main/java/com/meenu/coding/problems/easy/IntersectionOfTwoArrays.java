package com.meenu.coding.problems.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Meenu V. Nair
 * @created 21/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity :
     Building uniqueSet: O(n)
     Iterating nums2: O(m)
     Constructing result array: O(k), where k = intersection size

     Overall: O(n + m) (best possible, since you must at least read both arrays).

 Space Complexity :
     uniqueSet: up to O(n)
     intersection: up to O(min(n, m))

     Overall: O(n + m)

 */

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> uniqueSet = new HashSet<>();
        for(int num : nums1) {
            uniqueSet.add(num);
        }

        Set<Integer> intersection = new HashSet<>();
        for(int num : nums2) {
            if(uniqueSet.contains(num)) {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for(int num : intersection)
            result[index++] = num;
        return result;
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 Example 1:

 Input: nums1 = [1,2,2,1], nums2 = [2,2]
 Output: [2]
 Example 2:

 Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 Output: [9,4]
 Explanation: [4,9] is also accepted.


 Constraints:

 1 <= nums1.length, nums2.length <= 1000
 0 <= nums1[i], nums2[i] <= 1000
 */
