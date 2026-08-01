class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int row = heights.length;
        int col = heights[0].length;
        
        // Primitive boolean arrays automatically default to false in Java
        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        // DFS from Left and Right borders
        for (int i = 0; i < row; i++) {
            dfs(i, 0, pac, heights[i][0], row, col, heights);
            dfs(i, col - 1, atl, heights[i][col - 1], row, col, heights);
        }

        // DFS from Top and Bottom borders
        for (int i = 0; i < col; i++) {
            dfs(0, i, pac, heights[0][i], row, col, heights);
            dfs(row - 1, i, atl, heights[row - 1][i], row, col, heights);
        }

        // Find cells that can flow into both oceans
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    public void dfs(int r, int c, boolean[][] visit, int prev, int row, int col, int[][] heights) {
        // Base case: check grid boundaries, visited state, and reverse-flow height condition
        if (r < 0 || c < 0 || r >= row || c >= col || visit[r][c] || heights[r][c] < prev) {
            return;
        }

        visit[r][c] = true;

        // Explore all 4 adjacent directions
        dfs(r + 1, c, visit, heights[r][c], row, col, heights);
        dfs(r - 1, c, visit, heights[r][c], row, col, heights);
        dfs(r, c + 1, visit, heights[r][c], row, col, heights);
        dfs(r, c - 1, visit, heights[r][c], row, col, heights);
    }
}