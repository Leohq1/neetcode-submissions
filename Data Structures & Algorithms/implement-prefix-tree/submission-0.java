class PrefixTree {

    PrefixTreeNode root;

    public PrefixTree() {
        root = new PrefixTreeNode();
    }

    public void insert(String word) {
        PrefixTreeNode cur = root;
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                PrefixTreeNode update = new PrefixTreeNode();
                cur.children.put(c, update);
                cur = update;
            } else{
                cur = cur.children.get(c);
            }
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTreeNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            } else{
                return false;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTreeNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            } else{
                return false;
            }
        }
        return true;
    }
    
    private class PrefixTreeNode {
        public boolean isEnd;
        public Map<Character, PrefixTreeNode> children;
        
        //contructor
        public PrefixTreeNode() {
            isEnd = false;
            children = new HashMap<>();
        }
    }
}

