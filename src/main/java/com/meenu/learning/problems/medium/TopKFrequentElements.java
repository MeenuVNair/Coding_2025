package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(nlogk)
 Space complexity: O(n+k)
                    Where n is the length of the array and k is the number of top frequent elements.
 */

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(new int[]{entry.getValue(), entry.getKey()});
            if(minHeap.size() > k)
                minHeap.poll();
        }
        int[] topKFreq = new int[k];
        for(int i = 0; i < k; i++) {
            topKFreq[i] = minHeap.poll()[1];
        }
        return topKFreq;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



 Example 1:

 Input: nums = [1,1,1,2,2,3], k = 2
 Output: [1,2]
 Example 2:

 Input: nums = [1], k = 1
 Output: [1]


 Constraints:

 1 <= nums.length <= 105
 -104 <= nums[i] <= 104
 k is in the range [1, the number of unique elements in the array].
 It is guaranteed that the answer is unique.


 Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
