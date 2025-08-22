package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.Collections;
import java.util.PriorityQueue;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(logn) for adding numbers and O(1) for finding median
 Space Complexity : O(n)
 */

public class FindMedianFromDataStream {
    PriorityQueue<Integer> smallNumbers;
    PriorityQueue<Integer> largeNumbers;

    public FindMedianFromDataStream() {
        smallNumbers = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
        largeNumbers = new PriorityQueue<>(); // minHeap
    }

    public void addNum(int num) {
        // Push to the max heap and swap with min heap if needed.
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

    public double findMedian() {
        // odd number of elements
        if(smallNumbers.size() > largeNumbers.size())
            return smallNumbers.peek();
        else if(largeNumbers.size() > smallNumbers.size())
            return largeNumbers.peek();
        else
            return (double) (smallNumbers.peek() + largeNumbers.peek()) / 2; // Even # of elements, return avg of two middle nums
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println("Median : " + obj.findMedian()); // 1.5
        obj.addNum(3);
        System.out.println("Median : " + obj.findMedian()); // 2.0
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

 For example, for arr = [2,3,4], the median is 3.
 For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 Implement the MedianFinder class:

 MedianFinder() initializes the MedianFinder object.
 void addNum(int num) adds the integer num from the data stream to the data structure.
 double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.


 Example 1:

 Input
 ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 [[], [1], [2], [], [3], []]
 Output
 [null, null, null, 1.5, null, 2.0]

 Explanation
 MedianFinder medianFinder = new MedianFinder();
 medianFinder.addNum(1);    // arr = [1]
 medianFinder.addNum(2);    // arr = [1, 2]
 medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 medianFinder.addNum(3);    // arr[1, 2, 3]
 medianFinder.findMedian(); // return 2.0


 Constraints:

 -105 <= num <= 105
 There will be at least one element in the data structure before calling findMedian.
 At most 5 * 104 calls will be made to addNum and findMedian.


 Follow up:

 If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 */
