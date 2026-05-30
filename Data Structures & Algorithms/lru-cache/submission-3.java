class LRUCache {

    public record Pair<K, V>(K key, V value) {}

    private int capacity;
    private Deque<Pair<Integer, Integer>> deque;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.deque = new ArrayDeque<>();
    }

    public int get(int key) {
        Pair<Integer, Integer> found = null;

        for (Pair<Integer, Integer> pair : deque) {
            if (pair.key() == key) {
                found = pair;
                break;
            }
        }

        if (found == null)
            return -1;

        // Move to front (most recently used)
        deque.remove(found);
        deque.offerFirst(found);

        return found.value();
    }

    public void put(int key, int value) {

        Pair<Integer, Integer> found = null;

        // Check if key already exists
        for (Pair<Integer, Integer> pair : deque) {
            if (pair.key() == key) {
                found = pair;
                break;
            }
        }

        if (found != null) {
            // Remove old entry
            deque.remove(found);
        } else if (deque.size() == capacity) {
            // Remove least recently used
            deque.pollLast();
        }

        // Insert as most recently used
        deque.offerFirst(new Pair<>(key, value));
    }
}