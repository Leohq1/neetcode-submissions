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
        int[] index = new int[]{0};
        return dfsD(list, index);
    }

    private TreeNode dfsD(String[] list, int[] index){
        if(list[index[0]].charAt(0) == 'N'){
            index[0]++;
            return null;
        }

        TreeNode cur = new TreeNode(Integer.parseInt(list[index[0]]));
        index[0]++;

        cur.left = dfsD(list, index);
        cur.right = dfsD(list, index);
        return cur;
    }
}




















