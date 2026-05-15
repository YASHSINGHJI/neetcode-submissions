

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int cpy;

    public KthLargest(int k, int[] nums) {
        cpy = k;
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : nums) {
            pq.offer(i);
        }

    }

    public int add(int val) {
        pq.offer(val);
        PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
        int y = 0;
        for (int i = 1; i <= cpy; i++) {
            y = temp.poll();
        }
        return y;

    }
}
