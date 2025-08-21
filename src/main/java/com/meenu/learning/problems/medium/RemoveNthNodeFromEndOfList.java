package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 07/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.learning.util.ListNode;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because the code iterates through the linked list twice, once to count the nodes and once to find the node to remove.
 Space Complexity:O(1) as the code uses a constant amount of extra space, regardless of the input size.
 */

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int totalNodeCount = 0;

        ListNode traverseNode = head;
        while(traverseNode != null) {
            totalNodeCount++;
            traverseNode = traverseNode.next;
        }

        if(totalNodeCount == n)
            return head.next;

        int positionToDelete = totalNodeCount - n;

        ListNode nodeBeforeTarget = head;
        for(int i = 1; i < positionToDelete; i++) {
            nodeBeforeTarget = nodeBeforeTarget.next;
        }
        nodeBeforeTarget.next = nodeBeforeTarget.next.next;

        return head;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given the head of a linked list, remove the nth node from the end of the list and return its head.

 Example 1:

 Input: head = [1,2,3,4,5], n = 2
 Output: [1,2,3,5]
 Example 2:

 Input: head = [1], n = 1
 Output: []
 Example 3:

 Input: head = [1,2], n = 1
 Output: [1]


 Constraints:

 The number of nodes in the list is sz.
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz


 Follow up: Could you do this in one pass?
 */
