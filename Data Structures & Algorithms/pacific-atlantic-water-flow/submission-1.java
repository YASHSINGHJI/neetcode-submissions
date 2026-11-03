class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        boolean[][] pac = new boolean[heights.length][heights[0].length];
        boolean[][] atl = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(i, 0, pac, heights[i][0], heights);
            dfs(i, heights[0].length - 1, atl, heights[i][heights[0].length - 1], heights);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(0, i, pac, heights[0][i], heights);
            dfs(heights.length - 1, i, atl, heights[heights.length - 1][i], heights);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return res;
    }
    public void dfs(int r, int c, boolean[][] visit, int prev, int[][] heights) {
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visit[r][c]
            || prev > heights[r][c])
            return;
        visit[r][c] = true;
        dfs(r + 1, c, visit, heights[r][c], heights);
        dfs(r, c + 1, visit, heights[r][c], heights);
        dfs(r, c - 1, visit, heights[r][c], heights);
        dfs(r - 1, c, visit, heights[r][c], heights);
    }
}
