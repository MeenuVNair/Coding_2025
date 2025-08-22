package com.meenu.learning.datastructures.tree;

import com.meenu.learning.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n)
 Space complexity: O(h)

 n is the number of nodes in the binary tree
 h is the height of the binary tree
 */

/************* RECURSIVE ********************/

/*public class BinaryTreePostorderTraversal {

    List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)
            return result;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }
}*/


/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(n)
 Space complexity: O(h)

 n is the number of nodes in the binary tree
 h is the height of the binary tree
 */

/************* ITERATIVE ********************/

public class BinaryTreePostorderTraversal {

    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> visit = new Stack<>();

        stack.push(root);
        visit.push(false);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            Boolean visited = visit.pop();
            if(currNode != null) {
                if(visited)
                    result.add(currNode.val);
                else {
                    stack.push(currNode);
                    visit.push(true);
                    stack.push(currNode.right);
                    visit.push(false);
                    stack.push(currNode.left);
                    visit.push(false);
                }
            }
        }
        return result;
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 Example 1:

 Input: root = [1,null,2,3]

 Output: [3,2,1]

 Explanation:

 Example 2:

 Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

 Output: [4,6,7,5,2,9,8,3,1]

 Explanation:

 Example 3:

 Input: root = []

 Output: []

 Example 4:

 Input: root = [1]

 Output: [1]

 Constraints:

 The number of the nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?
 */
