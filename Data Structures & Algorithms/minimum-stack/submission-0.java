class MinStack {
    private Node top;
    
    public MinStack() {
        top = null;
    }
    
    public void push(int value) {
        if(top == null){
            Node newNode = new Node(value, value, top);
            top = newNode;
        }
        
        else{
            Node newNode = new Node(value, Math.min(value, top.min), top);
            top = newNode;
        }
        
    }
    
    public void pop() {
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        public Node(int val, int min, Node next){
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}



/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */