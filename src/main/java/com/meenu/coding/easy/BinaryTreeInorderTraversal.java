package com.meenu.coding.easy;


import com.meenu.coding.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author meenuvnair
 * @created 31/07/25
 */

// ****** RECURSSION *********** //

/*
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if(root == null)
            return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}

*/

// ****** ITERATIVE *********** //

class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}

/**
 Given the root of a binary tree, return the inorder traversal of its nodes' values.



 Example 1:

 Input: root = [1,null,2,3]

 Output: [1,3,2]

 Explanation:



 Example 2:

 Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

 Output: [4,2,6,5,7,1,3,9,8]

 Explanation:



 Example 3:

 Input: root = []

 Output: []

 Example 4:

 Input: root = [1]

 Output: [1]

 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
