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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //ListNode result = new ListNode(cur1.val + cur2.val);
        //ListNode cur = result;
        cur1.val = cur1.val + cur2.val;
        while(cur1.next != null && cur2.next != null){
            cur1.next.val = cur1.next.val + cur2.next.val;
            cur1 = cur1.next;
            cur2 = cur2.next;
            //cur = cur.next;
        }
        if(cur1.next == null){
            cur1.next = cur2.next;
        }
        cur1 = l1;
        boolean carry = false;
        while(cur1 != null){
            if(carry){
                cur1.val++;
            }
            if(cur1.val >= 10){
                cur1.val -= 10;
                carry = true;
            } else{
                carry = false;
            }
            if(cur1.next == null && carry == true){
                cur1.next = new ListNode(1);
                carry = false;
            }
            cur1 = cur1.next;
        }
        return l1;
    }
}
