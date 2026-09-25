/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>(); //old -> new
        Node result = (head == null) ? null : new Node(head.val);
        Node pointer = head;
        Node nPointer = result;
        while(pointer != null){
            nPointer.next = (pointer.next == null) ? null : new Node(pointer.next.val);
            map.put(pointer, nPointer);
            pointer = pointer.next;
            nPointer = nPointer.next;
        }
        pointer = head;
        nPointer = result;
        while(pointer != null){
            nPointer.random = (pointer.random == null) ? null : map.get(pointer.random);
            pointer = pointer.next;
            nPointer = nPointer.next;
        }
        return result;
    }
}