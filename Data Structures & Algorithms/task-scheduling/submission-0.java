class Solution {
      public int leastInterval(char[] tasks, int n) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : tasks) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int count : map.values()) {
        pq.offer(count);
    }

    Queue<int[]> q = new LinkedList<>();
    int time = 0;

    while (!pq.isEmpty() || !q.isEmpty()) {
        time++;

        if (!pq.isEmpty()) {
            int cnt = pq.poll() - 1;
            if (cnt > 0) {
                q.offer(new int[] { cnt, time + n });
            }
        }

        
        while (!q.isEmpty() && q.peek()[1] == time) {
            pq.offer(q.poll()[0]);
        }
    }

    return time;
}

}
