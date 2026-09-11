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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String result = "";
        if(root == null) return result;
        
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        while(!q.isEmpty()){
            TreeNode temp = q.removeFirst();
            if(temp == null){
                result += ",";
                continue;
            }
            result += temp.val;
            result += ",";
            q.addLast(temp.left);
            q.addLast(temp.right);
        }
        result = result.replaceAll(",+$", "");
        System.out.println(result);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] parsed = data.split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(parsed[index]));
        index++;
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        while(!q.isEmpty()){
            TreeNode temp = q.removeFirst();
            if(index < parsed.length && parsed[index].length() != 0){
                temp.left = new TreeNode(Integer.parseInt(parsed[index]));
                q.addLast(temp.left);
            }
            index++;
            if(index < parsed.length && parsed[index].length() != 0){
                temp.right = new TreeNode(Integer.parseInt(parsed[index]));
                q.addLast(temp.right);
            }
            index++;
        }
        return root;
    }
}
