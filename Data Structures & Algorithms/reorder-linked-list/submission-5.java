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
        ListNode fast=head,slow=head;
        while (fast!=null && fast.next!=null && fast.next.next!=null) {
            slow=slow.next;
            fast=fast.next.next;            
        }
        while(fast.next!=null){
            fast=fast.next;
        }
        ListNode prev=null;
        ListNode temp=slow.next;
        while (temp!=null) {
            ListNode x=temp.next;
            temp.next=prev;
            prev=temp;
            temp=x;
        }
        slow.next=null;
        ListNode first=head;
        ListNode second=prev;        

        while (second!=null) {
            ListNode next_first=first.next;
            ListNode next_second=second.next;
            first.next=second;
            second.next=next_first;
            first=next_first;
            second=next_second;
        }

    }
}
