/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(size == 0 || size == 1) return;
        temp = head;
        int half = size / 2 + size % 2;
        for(int i = 0; i < half - 1; i++){
            temp = temp.next;
        }
        ListNode second = temp.next;
        temp.next = null;
        second = reverse(second);
        head = merge(head, second);
    }

    private ListNode merge(ListNode first, ListNode second){
        ListNode one = first;
        ListNode two = second;
        ListNode cur = first;
        one = one.next;
        int size = 1;
        while(one != null || two != null){
            if(size % 2 == 1){
                cur.next = two;
                two = two.next;
            } else{
                cur.next = one;
                one = one.next;
            }
            cur = cur.next;
            size++;
        }
        return first;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            next = (next != null) ? next.next : null;
        }
        return prev;
    }
}
