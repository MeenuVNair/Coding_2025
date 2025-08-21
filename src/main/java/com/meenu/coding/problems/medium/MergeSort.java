package com.meenu.coding.problems.medium;


import com.meenu.coding.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class MergeSort {
    public List<Pair> mergeSort(List<Pair> pairs) {
        int left = 0;
        int right = pairs.size() - 1;
        mergerSortRecurssion(pairs, left, right);
        return pairs;
    }

    public List<Pair> mergerSortRecurssion(List<Pair> pairs, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergerSortRecurssion(pairs, left, mid);
            mergerSortRecurssion(pairs, mid + 1, right);
            merge(pairs, left, mid, right);
        }
        return pairs;
    }

    public List<Pair> merge(List<Pair> pairs, int left, int mid, int right) {
        //int n1 = (mid - left) + 1;
        //int n2 = right - mid;

        List<Pair> L = new ArrayList<>(pairs.subList(left, mid + 1));
        List<Pair> R = new ArrayList<>(pairs.subList(mid + 1, right + 1));

        //for(int i = 0; i < n1; i++) {
        //  L.set(i, pairs.get(left + i));
        //}
        //for(int j = 0; j < n2; j++) {
        //  R.set(j, pairs.get(mid + 1 + j));
        // }

        int i = 0, j = 0, k = left;

        while(i < L.size() && j < R.size()) {
            if(L.get(i).key <= R.get(j).key) {
                pairs.set(k++, L.get(i++));
            } else {
                pairs.set(k++, R.get(j++));
            }
        }

        while(i < L.size()) {
            pairs.set(k++, L.get(i++));
        }
        while(j < R.size()) {
            pairs.set(k++, R.get(j++));
        }
        return pairs;
    }
}


/**
 Implement Merge Sort.

 Merge Sort is a divide-and-conquer algorithm for sorting an array or list of elements. It works by recursively dividing the unsorted list into n sub-lists, each containing one element. Then, it repeatedly merges sub-lists to produce new sorted sub-lists until there is only one sub-list remaining.

 Objective:

 Given a list of key-value pairs, sort the list by key using Merge Sort. If two key-value pairs have the same key, maintain their relative order in the sorted list.

 Input:

 pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 Example 1:

 Input:
 pairs = [(5, "apple"), (2, "banana"), (9, "cherry"), (1, "date"), (9, "elderberry")]

 Output:
 [(1, "date"), (2, "banana"), (5, "apple"), (9, "cherry"), (9, "elderberry")]
 Note: As you can see, the solution is always stable. The two pairs with the key 9 maintained their relative positions.

 Example 2:

 Input:
 pairs = [(3, "cat"), (2, "dog"), (3, "bird")]

 Output:
 [(2, "dog"), (3, "cat"), (3, "bird")]
 */
