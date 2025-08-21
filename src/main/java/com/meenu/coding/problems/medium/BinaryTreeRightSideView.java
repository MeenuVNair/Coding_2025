package com.meenu.coding.problems.medium;


import com.meenu.coding.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            int right = -1;
            for(int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                right = node.val;
                if(node.left != null) {
                    queue.add(node.left);
                    right = node.val;
                }
                if(node.right != null) {
                    queue.add(node.right);
                    right = node.val;
                }
            }
            result.add(right);
        }
        return result;
    }
}


/**
 Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.



 Example 1:

 Input: root = [1,2,3,null,5,null,4]

 Output: [1,3,4]

 Explanation:



 Example 2:

 Input: root = [1,2,3,4,null,null,null,5]

 Output: [1,3,4,5]

 Explanation:



 Example 3:

 Input: root = [1,null,3]

 Output: [1,3]

 Example 4:

 Input: root = []

 Output: []



 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100
 */

