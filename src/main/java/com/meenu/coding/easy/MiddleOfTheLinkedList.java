package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ********************
 Fast and slow pointers

 1. We have two pointers start at the head of the linked list, one fast and one slow.
 2. fast pointer moves twice as fast as the slow pointer.
 3. By the time the fast pointer gets to the end, the slow pointer would be at the middle of the linked list.

 This makes sense because if the slow pointer is traveling at half the speed of the fast pointer,
 and the fast pointer has reached the end, then the slow pointer must be in the middle.

 */

import com.meenu.coding.util.ListNode;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(1)
 */

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given the head of a singly linked list, return the middle node of the linked list.

 If there are two middle nodes, return the second middle node.

 Example 1:

 Input: head = [1,2,3,4,5]
 Output: [3,4,5]
 Explanation: The middle node of the list is node 3.
 Example 2:


 Input: head = [1,2,3,4,5,6]
 Output: [4,5,6]
 Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


 Constraints:

 The number of nodes in the list is in the range [1, 100].
 1 <= Node.val <= 100
 */
