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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Deque<TreeNode> q = new LinkedList<>();
        int result = 0;
        q.addLast(root);
        while(!q.isEmpty()){
            result++;
            int layerSize = q.size();
            for(int i = 0; i < layerSize; i++){
                TreeNode temp = q.removeFirst();
                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);
            }

        }
        return result;
    }
}
