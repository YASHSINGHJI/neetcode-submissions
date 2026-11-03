class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] arr = q.poll();
                int r = arr[0];
                int c = arr[1];

                add(grid, r + 1, c, q, row, col, grid[r][c]);
                add(grid, r - 1, c, q, row, col, grid[r][c]);
                add(grid, r, c + 1, q, row, col, grid[r][c]);
                add(grid, r, c - 1, q, row, col, grid[r][c]);
            }
        }
    }

    public void add(int[][] grid, int r, int c, Queue<int[]> q, int row, int col, int dist) {
        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] != Integer.MAX_VALUE)
            return;

        grid[r][c] = dist + 1;
        q.offer(new int[] {r, c});
    }
}
