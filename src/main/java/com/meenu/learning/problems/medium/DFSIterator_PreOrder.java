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

public class DFSIterator_PreOrder {
    TreeNode root;
    public DFSIterator_PreOrder() {
        root = new TreeNode();
    }

    public void DFS_PreOrder(TreeNode node) {
        Stack<TreeNode> callStack = new Stack<>();
        TreeNode currNode = root;

        while(currNode != null || !callStack.isEmpty()) {
            if(currNode != null) {
                System.out.print(currNode.val + " -> ");
                if(currNode.right != null)
                    callStack.push(currNode.right);
                currNode = currNode.left;
            } else {
                callStack.pop();
            }
        }
        System.out.println("null");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Traverse Binary Search Tree using DFS iteratively - preorder
 */
