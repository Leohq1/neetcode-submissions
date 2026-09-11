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
    public boolean isValidBST(TreeNode root) {
        return check(root, -1000000001, 1000000001);
    }

    private boolean check(TreeNode root, int min, int max){
        if(root == null) return true;
        if(!(root.val > min && root.val < max)) return false;
        return check(root.left, min, root.val) && check(root.right, root.val, max);
    }
}
