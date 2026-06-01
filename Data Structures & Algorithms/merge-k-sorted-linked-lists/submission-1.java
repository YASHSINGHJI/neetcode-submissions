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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];
    }
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode output = new ListNode(0);
        ListNode dumm = output;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dumm.next = list1;
                list1 = list1.next;

            } else {
                dumm.next = list2;
                list2 = list2.next;
            }
            dumm = dumm.next;

            if (list1 != null) {
                dumm.next = list1;
            }
            if (list2 != null) {
                dumm.next = list2;
            }
        }

        return output.next;
    }
}
