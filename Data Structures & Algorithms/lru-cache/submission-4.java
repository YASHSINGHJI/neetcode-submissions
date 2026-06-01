

class LRUCache {
    class Node {
        Node next;
        Node prev;
        int key, val;

        public Node(int key, int val) {
            this.next = null;
            this.prev = null;
            this.key = key;
            this.val = val;
        }
    }

    private HashMap<Integer, Node> map;
    private int limit;
    private Node left, right;

    public LRUCache(int capacity) {
        this.limit = capacity;
        this.map = new HashMap<>();
        this.left = new Node(-1, -1);
        this.right = new Node(-1, -1);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node newNode = new Node(key, map.get(key).val);
        Node ans = map.get(key);
        map.remove(key);
        delNode(ans);
        addNode(newNode);
        map.put(key, newNode);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            delNode(map.get(key));
            map.remove(key);
        }
        if (limit == map.size()) {
            map.remove(right.prev.key);
            delNode(right.prev);
        }
        Node x = new Node(key, value);
        addNode(x);
        map.put(key, x);

    }

    public void addNode(Node node) {
        Node temp = left.next;
        left.next = node;
        node.next = temp;
        temp.prev = node;
        node.prev = left;
    }

    public void delNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}