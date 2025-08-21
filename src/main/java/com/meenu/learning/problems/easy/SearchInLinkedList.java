package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.learning.util.ListNode;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because in the worst case, it iterates through all the elements of the linked list.
 Space Complexity:O(1) because it uses a constant amount of extra space.
 */

public class SearchInLinkedList {
    public boolean searchKey(ListNode head, int key) {
        while(head != null) {
            if(head.val == key)
                return true;
            head = head.next;
        }
        return false;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given the head of a singly linked list and an integer key.

 Return true if the key exists in the linked list, otherwise return false.


 Examples:
 Input: head = [1, 2, 3, 4], key = 3

 Output: true

 Explanation: The linked list is 1 → 2 → 3 → 4. The key 3 is present in the list.

 Input: head = [7, 8, 9, 10, 11], key = 5

 Output: false

 Explanation: The key 5 is not present in the list.

 Input: head = [42], key = 42

 Output:
 true
 false

 Submit
 Constraints:
 The number of nodes in the linked list is in the range 1 <= n <= 10⁵.
 The value of each node is in the range 1 <= Node.val <= 10⁵.
 1 <= key <= 10⁵
 */
