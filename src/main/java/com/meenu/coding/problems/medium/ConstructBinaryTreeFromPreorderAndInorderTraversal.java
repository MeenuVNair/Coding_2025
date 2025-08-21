package com.meenu.coding.problems.medium;


import com.meenu.coding.util.TreeNode;

import java.util.Arrays;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;

        int mid = -1;
        TreeNode root = new TreeNode(preorder[0]);
        for(int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]) {
                mid = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
