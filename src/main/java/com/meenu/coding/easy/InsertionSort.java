package com.meenu.coding.easy;


import com.meenu.coding.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
* @author Meenu V. Nair
* @created 31/07/25
*/

// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class InsertionSort {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> sortResults = new ArrayList<>();

        for(int i = 0; i < pairs.size(); i++) {
            int j = i - 1;
            while(j >= 0 && pairs.get(j + 1).key < pairs.get(j).key) {
                Pair temp = pairs.get(j + 1);
                pairs.set((j + 1), pairs.get(j));
                pairs.set(j, temp);
                j--;
            }
            List<Pair> currentList = new ArrayList<>(pairs);
            sortResults.add(currentList);
        }
        return sortResults;
    }
}

/**
 Implement Insertion Sort and return intermediate states.

 Insertion Sort is a simple sorting algorithm that builds the sorted list one element at a time, from left to right. It works by repeatedly taking an element from the unsorted portion and inserting it into its correct position in the sorted portion of the list.

 Objective:

 Given a list of key-value pairs, sort the list by key using Insertion Sort. Return a list of lists showing the state of the array after each insertion. If two key-value pairs have the same key, maintain their relative order in the sorted list.

 Input:

 pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 Example 1:

 Input:
 pairs = [(5, "apple"), (2, "banana"), (9, "cherry")]

 Output:
 [[(5, "apple"), (2, "banana"), (9, "cherry")],
 [(2, "banana"), (5, "apple"), (9, "cherry")],
 [(2, "banana"), (5, "apple"), (9, "cherry")]]
 Notice that the output shows the state of the array after each insertion. The last state is the final sorted array. There should be pairs.length states in total.

 Example 2:

 Input:
 pairs = [(3, "cat"), (3, "bird"), (2, "dog")]

 Output:
 [[(3, "cat"), (3, "bird"), (2, "dog")],
 [(3, "cat"), (3, "bird"), (2, "dog")],
 [(2, "dog"), (3, "cat"), (3, "bird")]]
 In this example, you can observe that the pairs with key=3 ("cat" and "bird") maintain their relative order, illustrating the stability of the Insertion Sort algorithm.
 */
