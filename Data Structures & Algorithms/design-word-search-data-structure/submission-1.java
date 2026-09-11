class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            } else{
                TrieNode toAdd = new TrieNode();
                cur.children.put(c, toAdd);
                cur = toAdd;
            }
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Deque<TrieNode> q = new LinkedList<>();
        q.addLast(root);
        for(char c : word.toCharArray()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                if(q.getFirst().children.containsKey(c)){
                    q.addLast(q.removeFirst().children.get(c));
                } else if(c == '.'){
                    q.addAll(q.removeFirst().children.values());
                } else{
                    q.removeFirst();
                }
            }
        }
        for(TrieNode node : q){
            if(node.isEnd == true) return true;
        }
        return false;
    }

    private class TrieNode {
        public boolean isEnd;
        public Map<Character, TrieNode> children;

        public TrieNode() {
            isEnd = false;
            children = new HashMap<>();
        }
    }
}
