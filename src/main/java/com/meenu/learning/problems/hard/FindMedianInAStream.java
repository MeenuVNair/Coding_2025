package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n log n) due to adding elements to the priority queues in a loop.
 Space Complexity:O(n) because the priority queues can store up to n elements.
 */

public class FindMedianInAStream {

    PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
    PriorityQueue<Integer> largeNumbers = new PriorityQueue<>(); // minHeap

    public List<Double> getMedian(int[] arr) {
        List<Double> medianList = new ArrayList<>();
        for(int num : arr) {
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

            medianList.add(findMedian());
        }
        return medianList;
    }
    private double findMedian() {
        // odd number of elements
        if(smallNumbers.size() > largeNumbers.size())
            return smallNumbers.peek();
        else if(largeNumbers.size() > smallNumbers.size())
            return largeNumbers.peek();
        else
            return (double) (smallNumbers.peek() + largeNumbers.peek()) / 2; // Even # of elements, return avg of two middle nums
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a stream of integers arr[], arriving one by one. After each new integer is added to the stream, output the median of all elements seen so far.

 Return a list of medians — one after each insertion — where:

 If the number of elements is odd, the middle element is the median.
 If the number of elements is even, the average of the two middle elements is the median.

 Examples:
 Input: arr = [5, 15, 1, 3, 2, 8]

 Output: [5.0, 10.0, 5.0, 4.0, 3.0, 4.0]

 Explanation:

 After inserting 5 → median = 5.0
 After inserting 15 → median = (5 + 15) / 2 = 10.0
 After inserting 1 → median = 5.0
 After inserting 3 → median = (3 + 5) / 2 = 4.0
 After inserting 2 → median = 3.0
 After inserting 8 → median = (3 + 5) / 2 = 4.0
 Input: arr = [2, 2, 2, 2]

 Output: [2.0, 2.0, 2.0, 2.0]

 Explanation: All values are equal, so median remains 2.0 throughout.

 Input: arr = [1, 3, 5, 7, 9]

 Output:
 [1.0, 2.0, 3.0, 4.5, 5.0]
 [1.0, 2.0, 3.0, 4.0, 5.0]
 [1.0, 2.0, 3.5, 4.5, 5.0]
 [1.0, 2.0, 3.5, 3.5, 5.0]

 Submit
 Constraints:
 1 <= arr.length <= 105
 1 <= arr[i] <= 106
 You must return the median after every insertion, in O(log N) time per insertion.
 */
