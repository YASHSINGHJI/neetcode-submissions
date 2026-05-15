

public class LRUCache {

    public class Node {
        int key, value;
        Node next, prev;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
            next = null;
            prev = null;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache;
    Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);

        if (cache.size() > capacity) {
            Node lru = head.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
