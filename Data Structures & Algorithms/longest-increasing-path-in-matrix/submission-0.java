class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, solve(i, j, matrix, row, col, dp));
            }
        }
        return ans;
    }
    public boolean isSafe(int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col) {
            return false;
        }
        return true;
    }
    public int solve(int i, int j, int[][] matrix, int row, int col, int[][] dp) {
        if (dp[i][j] != -1)
            return dp[i][j];
        int top = 0, down = 0, left = 0, right = 0, ans = 0;
        if (isSafe(i - 1, j, row, col) && matrix[i - 1][j] > matrix[i][j])
            down = solve(i - 1, j, matrix, row, col, dp);
        if (isSafe(i + 1, j, row, col) && matrix[i + 1][j] > matrix[i][j])
            top = solve(i + 1, j, matrix, row, col, dp);
        if (isSafe(i, j - 1, row, col) && matrix[i][j - 1] > matrix[i][j])
            left = solve(i, j - 1, matrix, row, col, dp);
        if (isSafe(i, j + 1, row, col) && matrix[i][j + 1] > matrix[i][j])
            right = solve(i, j + 1, matrix, row, col, dp);
        ans = 1 + Math.max(Math.max(top, down), Math.max(left, right));
        return dp[i][j] = ans;
    }
}
