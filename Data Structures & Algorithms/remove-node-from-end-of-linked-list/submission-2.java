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
    // Create a dummy node before the head to handle edge cases
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // Initialize two pointers
    ListNode fast = dummy;
    ListNode slow = dummy;

    // Move fast pointer n+1 steps ahead
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Move fast and slow until fast reaches the end
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    // Skip the target node
    slow.next = slow.next.next;

    // Return the head
    return dummy.next;
}

}
