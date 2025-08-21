package com.meenu.coding.problems.easy;

import com.meenu.coding.util.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

/** COMPLEXITY ANALYSIS

 Time Complexity:O(n), where n is the number of nodes in the linked list, due to iterating through the list once.
 Space Complexity:O(1), as the algorithm uses a constant amount of extra space regardless of the input size. Only a few pointers are used.
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }
}

/**

 Given the head of a singly linked list, reverse the list, and return the reversed list.



 Example 1:


 Input: head = [1,2,3,4,5]
 Output: [5,4,3,2,1]
 Example 2:


 Input: head = [1,2]
 Output: [2,1]
 Example 3:

 Input: head = []
 Output: []


 Constraints:

 The number of nodes in the list is the range [0, 5000].
 -5000 <= Node.val <= 5000


 Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
