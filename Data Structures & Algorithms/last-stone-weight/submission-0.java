class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.offer(stone);
        }
        if (pq.isEmpty())
            return 0;
        if (pq.size() <= 1)
            return pq.peek();
        while (pq.size() > 1) {
            int x = pq.remove();
            int y = pq.remove();
            if (x > y) {
                pq.offer(x - y);
            }
            if (y > x) {
                pq.offer(y - x);
            }

        }
        if (pq.isEmpty()) {
            return 0;
        }
        return pq.peek();

    }
}
