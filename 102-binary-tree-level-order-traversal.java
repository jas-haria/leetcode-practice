// https://leetcode.com/problems/binary-tree-level-order-traversa
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
// BFS
/*class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<Pair<TreeNode, Integer>> queue = new ArrayList<>();
        queue.add(new Pair(root, 1));
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> currentPair = queue.remove(0);
            TreeNode node = currentPair.getKey();
            int level = currentPair.getValue();
            if (node.left != null)
                queue.add(new Pair(node.left, level + 1));
            if (node.right != null)
                queue.add(new Pair(node.right, level + 1));
            if (result.size() < level) {
                result.add(new ArrayList<>());
            }
            result.get(level - 1).add(node.val);
        }
        return result;
    }
}*/

// DFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 1, result);
        return result;
    }
    
    private void helper(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null)
            return;
        if (list.size() < level) {
            list.add(new ArrayList<>());
        }
        list.get(level - 1).add(root.val);
        helper(root.left, level + 1, list);
        helper(root.right, level + 1, list);
    }
}