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

    // Step 1: Find the middle using slow and fast pointers
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Step 2: Reverse the second half
    ListNode sec_start = slow.next;
    slow.next = null; // Break the list
    ListNode prev = null;
    while (sec_start != null) {
        ListNode temp = sec_start.next;
        sec_start.next = prev;
        prev = sec_start;
        sec_start = temp;
    }

    // Step 3: Merge the two halves
    ListNode p1 = head;
    ListNode p2 = prev;
    while (p2 != null) {
        ListNode temp1 = p1.next;
        ListNode temp2 = p2.next;
        p1.next = p2;
        p2.next = temp1;
        p1 = temp1;
        p2 = temp2;
    }
}
}

