package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.learning.util.TreeNode;

import java.util.Stack;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

public class DFSIterator_InOrder {
    TreeNode root;
    public DFSIterator_InOrder() {
        root = new TreeNode();
    }

    public void DFSIterative(TreeNode root) {
        Stack<TreeNode> callStack = new Stack<>();
        TreeNode currNode = root;

        while(currNode != null || !callStack.isEmpty()) {
            if(currNode != null) {
                callStack.push(currNode);
                currNode = currNode.left;
            } else {
                currNode = callStack.pop();
                System.out.print(currNode.val + " -> ");
                currNode = currNode.right;
            }
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DFSIterator_InOrder obj = new DFSIterator_InOrder();
        TreeNode node = new TreeNode();
        node.val = 1;
        obj.DFSIterative(node);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
Traverse Binary Search Tree using DFS iteratively - Inorder
 */
