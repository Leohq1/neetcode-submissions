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
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode cur, int depth){
        if(cur == null) return;

        if(depth == result.size()) result.add(cur.val);

        dfs(cur.right, depth + 1);
        dfs(cur.left, depth + 1);
    }
}
