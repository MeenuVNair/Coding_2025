package com.meenu.learning.datastructures.tree;


/**
 * @author Meenu V. Nair
 * @created 22/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.learning.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n), where n is the number of nodes in the binary tree.
 Space Complexity:O(w), where w is the maximum width of the binary tree, which can be O(n) in the worst case (e.g., a complete binary tree).
 */

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null)
            queue.add(root);

        while(!queue.isEmpty()) {
            int qSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < qSize; i++) {
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                if(currNode.left != null)
                    queue.add(currNode.left);
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
            result.add(level);
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
