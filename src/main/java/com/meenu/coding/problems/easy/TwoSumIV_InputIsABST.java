package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

import com.meenu.coding.util.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(n) because in the worst case, it might have to visit all nodes in the BST.
 Space Complexity:O(n) due to the space used by the HashSet, which can store up to n elements in the worst-case scenario (a skewed tree).
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class TwoSumIV_InputIsABST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return checkTwoSum(root, k, set);
    }

    public boolean checkTwoSum(TreeNode root, int k, Set<Integer> set) {
        if(root == null)
            return false;

        if(set.contains(k - root.val))
            return true;

        set.add(root.val);

        return checkTwoSum(root.left, k, set) || checkTwoSum(root.right, k, set);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such that their sum is equal to k, or false otherwise.

 Example 1:

 Input: root = [5,3,6,2,4,null,7], k = 9
 Output: true
 Example 2:


 Input: root = [5,3,6,2,4,null,7], k = 28
 Output: false

 Constraints:

 The number of nodes in the tree is in the range [1, 104].
 -104 <= Node.val <= 104
 root is guaranteed to be a valid binary search tree.
 -105 <= k <= 105
 */
