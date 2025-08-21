package com.meenu.learning.problems.medium;

import com.meenu.learning.util.Pair;

import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class QuickSort {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortFunction(pairs, 0, pairs.size() - 1);
        return pairs;
    }

    public List<Pair> quickSortFunction(List<Pair> pairs, int l, int r) {
        if(l < r) {
            int partitionKey = partition(pairs, l, r);
            quickSortFunction(pairs, l, partitionKey - 1);
            quickSortFunction(pairs, partitionKey + 1, r);
        }
        return pairs;
    }

    public int partition(List<Pair> pairs, int low, int high) {
        int i = low - 1;
        int pivot = pairs.get(high).key;

        for(int j = low; j < high; j++) {
            if(pairs.get(j).key < pivot) {
                i++;
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(i));
                pairs.set(i, temp);
            }
        }
        Pair temp = pairs.get(high);
        pairs.set(high, pairs.get(i + 1));
        pairs.set(i + 1, temp);

        return i + 1;
    }
}

/**
 mplement Quick Sort.

 Quick Sort is a divide-and-conquer sorting algorithm that works by partitioning an array into two smaller sub-arrays based on a pivot element. The elements less than the pivot go to the left sub-array and those greater go to the right sub-array. The algorithm then recursively sorts the sub-arrays.

 Objective:

 Given a list of key-value pairs, sort the list by key using Quick Sort. For each partitioning step:

 Use the right-most element as the pivot.
 Elements less than the pivot should be placed to the left of the pivot, and elements greater than or equal to the pivot should be placed to the right of the pivot.
 The correctness of your solution will be determined based on these requirements.

 Input:

 pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 Example 1:

 Input:
 pairs = [(3, "cat"), (2, "dog"), (3, "bird")]

 Output:
 [(2, "dog"), (3, "bird"), (3, "cat")]
 Note: As you can see, the solution is not necessarily stable. The two pairs with the key 3 have switched their relative positions.

 Example 2:

 Input:
 pairs = [(5, "apple"), (9, "banana"), (9, "cherry"), (1, "date"), (9, "elderberry")]

 Output:
 [(1, "date"), (5, "apple"), (9, "elderberry"), (9, "cherry"), (9, "banana")]
 */
