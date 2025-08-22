package com.meenu.learning.problems.medium;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 
 We will maintain a max-heap and a min-heap.

 - In the max-heap, we store the smaller half of values from the stream.
 - Conversely, in the min-heap, we store the larger half of values from the stream.
 To ensure each value goes in the correct heap and both heaps are roughly the same size, we might need to shift some elements around.

 - The max-heap will store the smaller half of the values. Thus, the top of the max-heap will be the largest value in the smaller half.
 - The min-heap will store the larger half of the values. Thus, the top of the min-heap will be the smallest value in the larger half.
 This would mean that the largest value in our max-heap will be smaller than the smallest value in our min-heap. Thus, the median can be calculated by just retrieving the min and the max values from our respective heaps.

 If the number of elements in our array is even, both of our heaps will have an equal number of elements. If we have an odd number of elements, one heap's size will be greater than the other. At any given iteration, the sizes of both heaps should only differ by at most 1 element.
 */

/**** COMPLEXITY ANALYSIS ********************

 Time Complexity :
         Insertion: O(logn)
         Calculating median: O(1)
 Space Complexity : O(n)

 where n is the number of elements in the stream.

 */

public class MedianWithTwoHeaps {
    PriorityQueue<Integer> largeNumbers;
    PriorityQueue<Integer> smallNumbers;

    public MedianWithTwoHeaps() {
        largeNumbers = new PriorityQueue<>(); // minHeap
        smallNumbers = new PriorityQueue<>(Collections.reverseOrder()); // maxHeap
    }

    public void insert(int num) {
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

    public double getMedian() {
        //odd number of elements
        if(smallNumbers.size() > largeNumbers.size())
            return smallNumbers.peek();
        else if(largeNumbers.size() > smallNumbers.size())
            return largeNumbers.peek();
        else
            return (smallNumbers.peek() + largeNumbers.peek()) / 2; // Even # of elements, return avg of two middle nums
    }

    public static void main(String[] args) {
        MedianWithTwoHeaps obj = new MedianWithTwoHeaps();
        obj.insert(4);
        System.out.println("Median : " + obj.getMedian());
        obj.insert(7);
        System.out.println("Median : " + obj.getMedian());
        obj.insert(3);
        System.out.println("Median : " + obj.getMedian());
        obj.insert(5);
        System.out.println("Median : " + obj.getMedian());
        obj.insert(1);
        System.out.println("Median : " + obj.getMedian());
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Implement a Median finder, where new values are inserted into the set, and you have to getMedian from that set.

 */
