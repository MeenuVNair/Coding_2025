package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.learning.util.ListNode;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because the while loop iterates through each node in the linked list.
 Space Complexity:O(1) because it only uses a constant amount of extra space for the length variable.
 */

public class FindTheLengthOfTheLinkedList {
    public int getLength(ListNode head) {
        int length = 0;
        while(head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given the head of a singly linked list. Your task is to return the number of nodes in the linked list.


 Examples:
 Input: head = [1, 2, 3, 4, 5]

 Output: 5

 Input: head = [8, 6]

 Output: 2

 Input: head = [1]

 Output:
 1
 0

 Submit
 Constraints:
 0 <= number of nodes in the Linked List <= 105
 0 <= ListNode.val <= 104
 */
