package com.meenu.coding.easy;


import com.meenu.coding.util.TreeNode;

import java.util.Stack;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        stack.push(root);
        sumStack.push(targetSum - root.val);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currSum = sumStack.pop();

            if(node.left == null && node.right == null && currSum == 0)
                return true;
            if(node.right != null) {
                stack.push(node.right);
                sumStack.push(currSum - node.right.val);
            }
            if(node.left != null) {
                stack.push(node.left);
                sumStack.push(currSum - node.left.val);
            }
        }
        return false;
    }
}

/**
 *
 Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

 A leaf is a node with no children.



 Example 1:


 Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 Output: true
 Explanation: The root-to-leaf path with the target sum is shown.
 Example 2:


 Input: root = [1,2,3], targetSum = 5
 Output: false
 Explanation: There are two root-to-leaf paths in the tree:
 (1 --> 2): The sum is 3.
 (1 --> 3): The sum is 4.
 There is no root-to-leaf path with sum = 5.
 Example 3:

 Input: root = [], targetSum = 0
 Output: false
 Explanation: Since the tree is empty, there are no root-to-leaf paths.


 Constraints:

 The number of nodes in the tree is in the range [0, 5000].
 -1000 <= Node.val <= 1000
 -1000 <= targetSum <= 1000
 */
