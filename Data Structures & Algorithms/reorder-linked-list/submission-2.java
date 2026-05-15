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
        if(head.next==null || head==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        ListNode sec_start=slow.next;
        while(sec_start.next!=null){
            ListNode temp=sec_start.next;
            sec_start.next=temp.next;
            temp.next=slow.next;
            slow.next=temp;
        }
      
                   
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p1!=slow){
            slow.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=slow.next;
        }
            


    }
}
