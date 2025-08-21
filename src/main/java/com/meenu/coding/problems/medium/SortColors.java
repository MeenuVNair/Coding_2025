package com.meenu.coding.problems.medium;

// Time complexity : O(n)
// Space complexity : O(1) (for 0,1,2) or O(k) in general case

/**************** SOLUTION 1 *********** */

/*
class SortColors {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num : nums) {
            if(countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int i = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for(int j = 0 ; j < entry.getValue(); j++) {
                nums[i++] = entry.getKey();
            }
        }
    }
}
*/

/**************** SOLUTION 2 *********** */
// Time complexity : O(n)
// Space complexity : O(1)

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

class SortColors {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0};

        for (int num : nums){
            count[num] += 1;
        }

        int i = 0;
        for(int n = 0; n < count.length; n++) {
            for(int j = 0; j < count[n]; j++) {
                nums[i++] = n;
            }
        }
    }
}


/**
 *
 Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

 We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

 You must solve this problem without using the library's sort function.



 Example 1:

 Input: nums = [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Example 2:

 Input: nums = [2,0,1]
 Output: [0,1,2]


 Constraints:

 n == nums.length
 1 <= n <= 300
 nums[i] is either 0, 1, or 2.


 Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */