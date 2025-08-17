package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.coding.util.DoubleListNode;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:The time complexity is O(n) because the while loop iterates through each node in the doubly linked list once.
 Space Complexity:The space complexity is O(1) because it uses a constant amount of extra space for temp and currNode, regardless of the input size.
 */

public class ReverseADoublyLinkedList {
    public DoubleListNode reverseDLL(DoubleListNode head) {
        DoubleListNode currNode = head;
        DoubleListNode temp = null;
        while(currNode != null) {
            temp = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp;
            currNode = currNode.prev;
        }
        if(temp != null)
            head = temp.prev;

        return head;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given the head of a doubly linked list.



 Reverse the list in-place and return the new head of the reversed list.


 Examples:
 Input: head = [10, 20, 30]

 Output:﻿ [30, 20, 10]

 Input: head = [1, 3, 5, 7, 9]

 Output: [9, 7, 5, 3, 1]

 Input: head = [42]

 Output:
 [42]
 [42, null]
 [null, 42, null]
 [null, 42]

 Submit
 Constraints:
 1 <= number of nodes <= 106
 0 <= node.val <= 104
 */
