public class Solution {
    public class Pair {
        private int[] pos;
        private int sec;

        // Constructor
        public Pair(int[] pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }

    public int orangesRotting(int[][] grid) {
        int maxtime = 0;
        Queue<Pair> pq = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    pq.offer(new Pair(new int[] {i, j}, 0));
                    vis[i][j] = true;
                }
            }
        }
        while (!pq.isEmpty()) {
            Pair node = pq.poll();
            int i = node.pos[0];
            int j = node.pos[1];
            int t = node.sec;
            maxtime = Math.max(t, maxtime);
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && !vis[i - 1][j]) {
                vis[i - 1][j] = true;
                pq.offer(new Pair(new int[] {i - 1, j}, t + 1));
                grid[i - 1][j] = 2;
            }
            if (i + 1 < m && grid[i + 1][j] == 1 && !vis[i + 1][j]) {
                vis[i + 1][j] = true;
                pq.offer(new Pair(new int[] {i + 1, j}, t + 1));
                grid[i + 1][j] = 2;
            }
            if (j + 1 < n && grid[i][j + 1] == 1 && !vis[i][j + 1]) {
                vis[i][j + 1] = true;
                pq.offer(new Pair(new int[] {i, j + 1}, t + 1));
                grid[i][j + 1] = 2;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && !vis[i][j - 1]) {
                vis[i][j - 1] = true;
                pq.offer(new Pair(new int[] {i, j - 1}, t + 1));
                grid[i][j - 1] = 2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxtime;
    }
}
