package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n * k log k)
 Space Complexity :
 */

/*******  TIME LIMIT EXCEEDED ********************/

/**
 as we are rebuilding heaps for each sliding window, For n = 10^5 and k = 10^4, this will time out.
 */

/*public class SlidingWindowMedian {
    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> largeNumbers;
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        int index = 0;
        for(int i = 0; i + k <= nums.length; i++) {
            smallNumbers = new PriorityQueue<>(Collections.reverseOrder()); //maxHeap
            largeNumbers = new PriorityQueue<>(); // minHeap
            for(int j = i; j < i + k; j++) {
                addNumbers(nums[j]);
            }
            medians[index++] = findMedian();
            smallNumbers.remove(nums[i]);
            largeNumbers.remove(nums[i]);
        }
        return medians;
    }

    private void addNumbers(int num) {
        smallNumbers.add(num);
        int value;
        if(!smallNumbers.isEmpty() && !largeNumbers.isEmpty() && smallNumbers.peek() > largeNumbers.peek()) {
            value = smallNumbers.poll();
            largeNumbers.add(value);
        }

        // Handle uneven size
        if(smallNumbers.size() > largeNumbers.size() + 1) {
            value = smallNumbers.poll();
            largeNumbers.add(value);
        } else if(largeNumbers.size() > smallNumbers.size() + 1) {
            value = largeNumbers.poll();
            smallNumbers.add(value);
        }
    }

    private double findMedian() {
        // if number of elements is odd
        if(smallNumbers.size() > largeNumbers.size())
            return smallNumbers.peek();
        else if(largeNumbers.size() > smallNumbers.size())
            return largeNumbers.peek();
        else
            return (double) ((long) smallNumbers.peek() + (long) largeNumbers.peek()) / 2; // Even # of elements, return avg of two middle nums
    }

    public static void main(String[] args) {
        SlidingWindowMedian obj = new SlidingWindowMedian();

        //double[] result = obj.medianSlidingWindow(new int[] {1, 2, 3, 4}, 4);
        double[] result = obj.medianSlidingWindow(new int[] {2147483647, 2147483647}, 2);
        for(double num : result)
            System.out.println("Median : " + num);
        *//*obj.addNumbers(1);
        obj.addNumbers(4);
        obj.addNumbers(2);
        obj.addNumbers(3);
        System.out.println("Median : " + obj.findMedian());*//*
    }
}*/

/***************** OPTIMIZED *****************/

public class SlidingWindowMedian {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap;
    PriorityQueue<Integer> large = new PriorityQueue<>(); // minHeap
    Map<Integer, Integer> delayed = new HashMap<>();
    int smallSize = 0, largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // for first findow
            addNumbers(nums[i]);
        }
        medians[0] = findMedian();
        for(int i = k; i < nums.length; i++) { // for remaining windows
            removeNumber(nums[i - k]); // remove the number which has moved out of the window now
            addNumbers(nums[i]);
            medians[i - k + 1] = findMedian(); // find the median
        }
        return medians;
    }

    private void addNumbers(int num) {
        if(!small.isEmpty() && num <= small.peek()) {
            small.add(num);
            smallSize++;
        } else {
            large.add(num);
            largeSize++;
        }
        rebalance();
    }

    private double findMedian() {
        prune(small);
        prune(large);
        //for odd number of elements
        if(smallSize > largeSize)
            return small.peek();
        else if(largeSize > smallSize)
            return large.peek();
        else
            return ((long) small.peek() + (long) large.peek()) / 2.0; // for even number of elements
        // convert to long otherwise integer overflow will happend, convert to double at the end otherwise long will remove decimals from the result
    }

    private void removeNumber(int num) {
        // add it to a map and mark for lazy deletion. we will not delete it immediately as removing arbitrarily from heap is not efficient.
        // hence we will mark it for deletion and delete it only when it is on the top of the heap.
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if(!small.isEmpty() && num <= small.peek())
            smallSize--;
        else
            largeSize--;

        prune(small);
        prune(large);
        rebalance(); // rebalance so that difference is at most 1 always
    }

    private void prune(PriorityQueue<Integer> heap) {
        // check if the heap is not empty and the top element of the heap is marked for deletion
        // continue this for all the elements that come to top and are marked for deletion
        while(!heap.isEmpty() && delayed.getOrDefault(heap.peek(), 0) > 0) {
            int num = heap.poll();
            delayed.put(num, delayed.get(num) - 1);
            if(delayed.get(num) == 0)
                delayed.remove(num);
        }
    }

    private void rebalance() {
        // rebalance so that difference is at most 1 always
        // need to call prune because after rebalancing the node that comes to top might be a node which was previously marked for deletion
        if(smallSize > largeSize + 1) {
            large.add(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } else if (largeSize> smallSize + 1) {
            small.add(large.poll());
            smallSize++;
            largeSize--;
            prune(large);
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian obj = new SlidingWindowMedian();

        //double[] result = obj.medianSlidingWindow(new int[] {1, 2, 3, 4}, 4);
        //double[] result = obj.medianSlidingWindow(new int[] {2147483647, 2147483647}, 2);
        double[] result = obj.medianSlidingWindow(new int[] {1,2}, 1);
        for(double num : result)
            System.out.println("Median : " + num);
        /*obj.addNumbers(1);
        obj.addNumbers(4);
        obj.addNumbers(2);
        obj.addNumbers(3);
        System.out.println("Median : " + obj.findMedian());*/
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle values.

 For examples, if arr = [2,3,4], the median is 3.
 For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.



 Example 1:

 Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
 Explanation:
 Window position                Median
 ---------------                -----
 [1  3  -1] -3  5  3  6  7        1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7        3
 1  3  -1  -3 [5  3  6] 7        5
 1  3  -1  -3  5 [3  6  7]       6
 Example 2:

 Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
 Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]


 Constraints:

 1 <= k <= nums.length <= 105
 -231 <= nums[i] <= 231 - 1
 */
