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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode tail=head;
        while (tail.next!=null) {
            size++;
            tail=tail.next;
        }
        int remove_index=size-n+1;
        int start=0;
        tail=head;
        ListNode prev=tail;
        while (start!=remove_index) {
            prev=tail;            
            tail=tail.next;    
            start++;                    
        }
        if(prev==tail) return prev.next;
        prev.next=tail.next;
        return head;        


    }
}
