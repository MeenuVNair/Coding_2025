package com.meenu.coding.medium;


import java.util.PriorityQueue;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 Given an integer array nums and an integer k, return the kth largest element in the array.

 Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Can you solve it without sorting?



 Example 1:

 Input: nums = [3,2,1,5,6,4], k = 2
 Output: 5
 Example 2:

 Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 Output: 4


 Constraints:

 1 <= k <= nums.length <= 105
 -104 <= nums[i] <= 104
 */
