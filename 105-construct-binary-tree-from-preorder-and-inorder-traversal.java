// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
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
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, inorderMap, 0, preorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[preorderIndex]);
        preorderIndex++;
        int inorderIndex = inorderMap.get(root.val);
        root.left = buildTree(preorder, inorder, inorderMap, left, inorderIndex - 1);
        root.right = buildTree(preorder, inorder, inorderMap, inorderIndex + 1, right);
        return root;
    }
}