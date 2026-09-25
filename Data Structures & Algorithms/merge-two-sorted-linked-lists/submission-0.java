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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode result;
        ListNode pointer1 = list1;
        ListNode pointer2 = list2;
        if(list2.val > list1.val){
            result = list1;
            pointer1 = pointer1.next;
        } else{
            result = list2;
            pointer2 = pointer2.next;
        }
        ListNode resultPointer = result;
        
        while(pointer1 != null && pointer2 != null){
            if(pointer1.val > pointer2.val){
                resultPointer.next = pointer2;
                pointer2 = pointer2.next;
            } else{
                resultPointer.next = pointer1;
                pointer1 = pointer1.next;
            }
            resultPointer = resultPointer.next;
        }

        resultPointer.next = (pointer1 == null) ? pointer2 : pointer1;
        
        return result;
    }
}