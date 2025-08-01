package com.meenu.coding.medium;


import com.meenu.coding.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null) {
            return result;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> currentLevelValues = new ArrayList<>();
            int qSize = queue.size();
            for(int i = 0; i < qSize; i ++) {
                TreeNode node = queue.poll();
                currentLevelValues.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            result.add(currentLevelValues);
        }
        return result;
    }
}

/**
 Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



 Example 1:


 Input: root = [3,9,20,null,null,15,7]
 Output: [[3],[9,20],[15,7]]
 Example 2:

 Input: root = [1]
 Output: [[1]]
 Example 3:

 Input: root = []
 Output: []


 Constraints:

 The number of nodes in the tree is in the range [0, 2000].
 -1000 <= Node.val <= 1000
 */
