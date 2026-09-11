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
    private int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode cur){
        if(cur == null) return 0;

        int left = dfs(cur.left);
        int right = dfs(cur.right);

        int side = Math.max(left, right);
        int sides = Math.max(left + right, side);
        int maxCur = Math.max(sides + cur.val, cur.val);
        result = Math.max(result, maxCur);
        return (side > 0) ? side + cur.val : cur.val;
    }
}
