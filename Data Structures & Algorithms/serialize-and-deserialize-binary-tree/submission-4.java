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
        List<String> resultList = new ArrayList<>();
        dfsS(root, resultList);
        return String.join(",", resultList);
    }

    private void dfsS(TreeNode root, List<String> list){
        if(root == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(root.val));
        dfsS(root.left, list);
        dfsS(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] list = data.split(",");
        return dfsD(list);
    }

    private int index = 0;

    private TreeNode dfsD(String[] list){
        if(list[index].charAt(0) == 'N'){
            index++;
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(list[index]));
        index++;

        cur.left = dfsD(list);
        cur.right = dfsD(list);
        return cur;
    }
}




















