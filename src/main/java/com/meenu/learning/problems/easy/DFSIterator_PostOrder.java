package com.meenu.learning.problems.easy;


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

public class DFSIterator_PostOrder {
    TreeNode root;
    public DFSIterator_PostOrder() {
        root = new TreeNode();
    }

    public void DFS_PostOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();

        stack.push(node);
        visit.push(false);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            Boolean visited = visit.pop();
            if(currNode != null) {
                if(visited) {
                    System.out.print(currNode.val + " -> ");
                } else {
                    stack.push(currNode);
                    visit.push(true);
                    stack.push(currNode.right);
                    visit.push(false);
                    stack.push(currNode.left);
                    visit.push(false);
                }
            }
        }
        System.out.println("null");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Traverse Binary Search Tree using DFS iteratively - postorder
 */
