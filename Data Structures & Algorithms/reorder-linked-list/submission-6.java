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
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode temp = null;
        ListNode temp2 = slow.next;
        slow.next = null;
        while (temp2 != null) {
            ListNode x = temp2.next;
            temp2.next = temp;
            temp = temp2;
            temp2 = x;
        }
        ListNode temp3 = head;

        ListNode temp4 = temp;
        while (temp4 != null) {
            ListNode x = temp3.next;
            ListNode y = temp4.next;
            temp3.next = temp4;
            temp4.next = x;
            temp4 = y;
            temp3 = x;
        }

    }
}
