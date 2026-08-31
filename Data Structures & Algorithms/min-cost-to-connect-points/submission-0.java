class Solution {
    public int minCostConnectPoints(int[][] points) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> minH = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minH.offer(new int[] {0, 0});
        int res=0;
        while (set.size() < points.length) {
            int[] curr = minH.poll();
            int cost = curr[0];
            int i = curr[1];
            if (set.contains(i)) {
                continue;
            }
            res += cost;
            set.add(i);
            for (int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!set.contains(neiIndex)) {
                    minH.offer(new int[] {neiCost, neiIndex});
                }
            }
        }
        return res;
    }
}
