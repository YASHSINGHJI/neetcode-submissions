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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (true) {
            ListNode kth = getK(prev, k);
            if (kth == null) {
                break;
            }
            ListNode n = kth.next;
            ListNode p = n;
            ListNode curr = prev.next;
            while (curr != n) {
                ListNode temp = curr.next;
                curr.next = p;
                p = curr;
                curr = temp;
            }
            ListNode temp = prev.next;
            prev.next = kth;
            prev = temp;
        }
        return dummy.next;
    }
    public ListNode getK(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
