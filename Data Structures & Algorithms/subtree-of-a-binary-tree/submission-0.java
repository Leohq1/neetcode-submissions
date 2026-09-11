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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null) return false;
        if(subRoot == null) return true;
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            TreeNode temp = q.removeFirst();
            if(temp.val == subRoot.val && sameTree(temp, subRoot)) return true;
            if(temp.left != null) q.addLast(temp.left);
            if(temp.right != null) q.addLast(temp.right);
        }
        return false;
    }

    private boolean sameTree(TreeNode parent, TreeNode child){
        if(parent == null && child == null) return true;
        if(parent == null || child == null) return false;
        if(parent.val != child.val) return false;
        return sameTree(parent.left, child.left) && sameTree(parent.right, child.right);
    }
}