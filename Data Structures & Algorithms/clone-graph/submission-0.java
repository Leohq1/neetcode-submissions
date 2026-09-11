/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Node root = new Node(node.val);
        visited.put(node, root);
        dfs(node, root);
        return root;
    }

    Map<Node, Node> visited = new HashMap<>();

    private void dfs(Node original, Node current){
        if(original.neighbors.isEmpty()){
            return;
        }
        for(Node temp : original.neighbors){
            Node n;
            if(!visited.containsKey(temp)){
                n = new Node(temp.val);
                visited.put(temp, n);
                dfs(temp, n);
            } else{
                n = visited.get(temp);
            }
            current.neighbors.add(n);
        }
    }
}