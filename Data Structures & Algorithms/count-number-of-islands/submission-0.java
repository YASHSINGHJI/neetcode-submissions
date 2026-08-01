class Solution {
    public int numIslands(char[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[x][y];
        for(boolean[] visit:visited){
            Arrays.fill(visit, false);
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j, visited, x, y);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int i, int j, boolean[][] visited, int x, int y) {
        if (i >= x || j >= y || i < 0 || j < 0 || visited[i][j] || grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited, x, y);
        dfs(grid, i, j + 1, visited, x, y);
        dfs(grid, i + 1, j, visited, x, y);
        dfs(grid, i, j - 1, visited, x, y);
    }
}
