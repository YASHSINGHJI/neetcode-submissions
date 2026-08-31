class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        pq.offer(new int[] {grid[0][0], 0, 0});
        visit[0][0] = true;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int t = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == n - 1) {
                return t;
            }
            for (int[] direction : dir) {
                int neiR = r + direction[0];
                int neiC = c + direction[1];
                if (neiR >= 0 && neiC >= 0 && neiC < n && neiR < n && !visit[neiR][neiC]) {
                    visit[r][c] = true;
                    pq.offer(new int[] {Math.max(t, grid[neiR][neiC]), neiR, neiC});
                }
            }
        }
        return n*n;
    }
}
