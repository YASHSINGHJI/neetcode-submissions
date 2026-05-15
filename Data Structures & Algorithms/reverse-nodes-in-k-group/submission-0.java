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
        ListNode temp = head;
        int cnt = 0;
        while (cnt < k) {
            if (temp == null)
                return head;
            cnt++;
            temp = temp.next;
        }
        ListNode prev = reverseKGroup(temp, k);
        cnt = 0;
        temp = head;
        while (cnt < k) {
            ListNode nextnode = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nextnode;
            cnt++;

        }
        return prev;

    }
}
