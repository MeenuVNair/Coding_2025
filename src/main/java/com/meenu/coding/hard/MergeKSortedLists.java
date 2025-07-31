package com.meenu.coding.hard;

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

// Time complexity : O(N∗K)
// Space complexity : O(1)

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;

        for(int i = 1; i < lists.length; i++) {
            lists[i] = merge(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return temp.next;
    }
}

/**
 You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

 Merge all the linked-lists into one sorted linked-list and return it.



 Example 1:

 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 Output: [1,1,2,3,4,4,5,6]
 Explanation: The linked-lists are:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 merging them into one sorted linked list:
 1->1->2->3->4->4->5->6
 Example 2:

 Input: lists = []
 Output: []
 Example 3:

 Input: lists = [[]]
 Output: []


 Constraints:

 k == lists.length
 0 <= k <= 104
 0 <= lists[i].length <= 500
 -104 <= lists[i][j] <= 104
 lists[i] is sorted in ascending order.
 The sum of lists[i].length will not exceed 104.
 */
