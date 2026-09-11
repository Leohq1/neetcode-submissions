class LRUCache {

    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node temp = map.get(key);
        moveToFront(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            moveToFront(map.get(key));
        } else{
            size++;
            Node temp = new Node(key, value);
            map.put(key, temp);
            temp.next = head.next;
            head.next.prev = temp;

            head.next = temp;
            temp.prev = head;
            checkSize();
        }
    }

    private void checkSize(){
        while(size > capacity){
            Node temp = tail.prev;
            int tempKey = temp.key;
            tail.prev = tail.prev.prev;
            tail.prev.next = tail;
            map.remove(tempKey);
            size--;
        }
    }

    private void moveToFront(Node node){
        Node temp = node;
        node.prev.next = node.next;
        node.next.prev = node.prev;

        temp.next = head.next;
        head.next.prev = temp;

        head.next = temp;
        temp.prev = head;
    }

    private class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
