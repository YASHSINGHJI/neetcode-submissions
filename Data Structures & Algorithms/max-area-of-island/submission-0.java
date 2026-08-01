class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] visited = new boolean[x][y];
        for (boolean[] visit : visited) {
            Arrays.fill(visit, false);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int area = dfs(grid, i, j, visited, x, y);
                    maxarea = Math.max(maxarea, area);
                }
            }
        }
        return maxarea;

    }

    public int dfs(int[][] grid, int i, int j, boolean[][] visited, int x, int y) {
        if (i >= x || j >= y || i < 0 || j < 0 || visited[i][j] || grid[i][j] != 1) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(grid, i - 1, j, visited, x, y) +
                dfs(grid, i, j + 1, visited, x, y) +
                dfs(grid, i + 1, j, visited, x, y) +
                dfs(grid, i, j - 1, visited, x, y);

    }

}
