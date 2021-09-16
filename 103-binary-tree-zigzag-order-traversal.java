// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if (root == null)
           return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (level >= result.size())
            result.add(new ArrayList<>());
        if (level % 2 == 0)
            result.get(level).add(root.val);
        else
            result.get(level).add(0, root.val);
        dfs(root.left, level + 1, result);
        dfs(root.right, level + 1, result);
    }
}