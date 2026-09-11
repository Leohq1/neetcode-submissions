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
    private int result = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return result;
    }

    private void dfs(TreeNode root, int val){
        if(root == null) return;

        if(root.val >= val) {
            result++;
            val = root.val;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
