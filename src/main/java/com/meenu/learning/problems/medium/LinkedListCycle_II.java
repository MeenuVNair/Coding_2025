package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ******************** 
 First approach : HashSet
 - traverse linked list and add to hashset
 - while inserting each node, first check if it is already present
 - if present, then it is a cycle and return that node
 - else, return -1

 TC : O(n)
 SC : O(n) - due to hashset

 Second approach - Fast and slow pointers
 - slow = head, fast = head
 - fast moves two positions and slow moves one position
 - do this wile fast reaches end or if at some point fast and slow meets, ie., fast = slow
 - after the loop completes check if it is because of end of list or cycle
 - if not end of loop,
    - get a new slow pointer slow2 = head
    - increment both slow pointers one position at a time
    - when these two slow pointers meet, that will be the head of the cycle

 TC : O(n)
 SC : O(1)
 */

import com.meenu.learning.util.ListNode;

/**** COMPLEXITY ANALYSIS ********************
 TC : O(n)
 SC : O(n) - due to hashset
 */
/**************** First approach : HashSet ******************/

/*public class LinkedListCycle_II {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null) {
            if(set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}*/


/**** COMPLEXITY ANALYSIS ********************
 TC : O(n)
 SC : O(1)
 */

/**************** Second approach : Fast and slow pointers ******************/

public class LinkedListCycle_II {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast)
                break;
        }
        if(fast == null || fast.next == null) {
            return null;
        }

        ListNode slow2 = head;
        while(slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

 There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

 Do not modify the linked list.



 Example 1:


 Input: head = [3,2,0,-4], pos = 1
 Output: tail connects to node index 1
 Explanation: There is a cycle in the linked list, where tail connects to the second node.
 Example 2:


 Input: head = [1,2], pos = 0
 Output: tail connects to node index 0
 Explanation: There is a cycle in the linked list, where tail connects to the first node.
 Example 3:


 Input: head = [1], pos = -1
 Output: no cycle
 Explanation: There is no cycle in the linked list.


 Constraints:

 The number of the nodes in the list is in the range [0, 104].
 -105 <= Node.val <= 105
 pos is -1 or a valid index in the linked-list.


 Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
