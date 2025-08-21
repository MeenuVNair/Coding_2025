package com.meenu.learning.util;


/**
 * @author Meenu V. Nair
 * @created 17/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class DoubleListNode {
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;
    public DoubleListNode() {}
    public DoubleListNode(int val) { this.val = val; }
    public DoubleListNode(int val, DoubleListNode next) { this.val = val; this.next = next; }
    public DoubleListNode(int val, DoubleListNode prev, DoubleListNode next) { this.val = val; this.prev = prev; this.next = next; }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
