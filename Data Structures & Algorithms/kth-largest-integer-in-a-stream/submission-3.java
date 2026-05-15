

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int cpy;

    public KthLargest(int k, int[] nums) {
        cpy = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
        }

    }

     public int add(int val) {
        pq.offer(val);
        while (pq.size() > cpy) {
            pq.remove();
        }
        return pq.peek();

    }
}
