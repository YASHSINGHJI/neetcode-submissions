/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node new_head = new Node(head.val);        new_head.val = head.val;
        Node old_current = head;
        Node new_current = new_head;
        map.put(old_current, new_current);
        while (old_current != null) {
            if(old_current.next == null) {
                new_current.next = null;
            } else {
                new_current.next = new Node(old_current.next.val);
            }
            old_current = old_current.next;
            new_current = new_current.next;
            map.put(old_current, new_current);
        }
        old_current = head;
        new_current = new_head;
        while (old_current != null) {
            if (old_current.random == null) {
                new_current.random = null;
            } else {                
            new_current.random = map.get(old_current.random);
            }
            old_current = old_current.next;
            new_current = new_current.next;
        }
        return new_head;

    }
}
