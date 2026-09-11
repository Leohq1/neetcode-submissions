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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.removeFirst();
                list.add(temp.val);
                if(temp.left != null) q.addLast(temp.left);
                if(temp.right != null) q.addLast(temp.right);
            }
            result.add(list);
        }
        return result;
    }
}