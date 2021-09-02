// https://leetcode.com/problems/merge-two-binary-trees
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
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        int value = 0;
        TreeNode root1left = null, root1right = null, root2left = null, root2right = null;
        if (root1 != null) {
            value += root1.val;
            root1left = root1.left;
            root1right = root1.right;
        }
        if (root2 != null) {
            value += root2.val;
            root2left = root2.left;
            root2right = root2.right;
        }
        return new TreeNode(value, mergeTrees(root1left, root2left),
                            mergeTrees(root1right, root2right));
    }
}