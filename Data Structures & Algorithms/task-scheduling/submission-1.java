class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            if (map.containsKey(task)) {
                map.put(task, map.get(task) + 1);
            } else {
                map.put(task, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char task : map.keySet()) {
            pq.add(map.get(task));
        }
        int time = 0;
        Deque<int[]> deque = new LinkedList<>();
        while (!pq.isEmpty() || !deque.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int cur = pq.poll() - 1;
                if (cur > 0)
                    deque.offerLast(new int[] {cur, time + n});
            }
            if (!deque.isEmpty() && deque.peek()[1] == time) {
                pq.offer(deque.pollFirst()[0]);
            }
        }
        return time;
    }
}
