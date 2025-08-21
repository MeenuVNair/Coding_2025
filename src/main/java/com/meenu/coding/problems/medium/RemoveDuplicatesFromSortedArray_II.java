package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 14/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

/**************    WITH USING EXTRA SPACE ************/

/*public class RemoveDuplicatesFromSortedArray_II {
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= 2) {
                nums[i] = nums[i + 1] = entry.getKey();
                i = i + 2;
            } else {
                nums[i++] = entry.getKey();
            }
        }
        return i;
    }
}*/

/************** TWO-POINTERS -- WITHOUT EXTRA SPACE ************/

/**
 l → the position where we will put the next valid number.
 r → the position we are currently checking in the array.

 Loop through all elements using r.
 Count how many times the current number appears.
 Keep moving r forward while the next number is the same.
 Increment count as well to keep track of the duplicates.

 We only allow up to 2 copies of the same number.
 Math.min(2, count) ensures we never add more than 2.
 We place those allowed copies at the front (using index l).

 Move r to the next new number and repeat.

 Return the new length of the array after removing extra duplicates.
 Everything from nums[0] to nums[l-1] is now the cleaned version.

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(1)
 */

public class RemoveDuplicatesFromSortedArray_II {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while(r < nums.length) {
            int count = 1;
            while(r + 1 < nums.length && nums[r] == nums[r + 1]) {
                r++;
                count++;
            }
            for(int i = 0; i < Math.min(2, count); i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

 Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

 Return k after placing the final result in the first k slots of nums.

 Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

 Custom Judge:

 The judge will test your solution with the following code:

 int[] nums = [...]; // Input array
 int[] expectedNums = [...]; // The expected answer with correct length

 int k = removeDuplicates(nums); // Calls your implementation

 assert k == expectedNums.length;
 for (int i = 0; i < k; i++) {
 assert nums[i] == expectedNums[i];
 }
 If all assertions pass, then your solution will be accepted.



 Example 1:

 Input: nums = [1,1,1,2,2,3]
 Output: 5, nums = [1,1,2,2,3,_]
 Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 Example 2:

 Input: nums = [0,0,1,1,1,1,2,3,3]
 Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).


 Constraints:

 1 <= nums.length <= 3 * 104
 -104 <= nums[i] <= 104
 nums is sorted in non-decreasing order.
 */
