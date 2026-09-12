class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] r : dp) {
            Arrays.fill(r, -1);
        }
        return solve(0, 0, word1, word2, dp);
    }
    public int solve(int i, int j, String w1, String w2, int[][] dp) {
        if (i == w1.length())
            return w2.length() - j;
        if (j == w2.length())
            return w1.length() - i;
        if (dp[i][j] != -1)
            return dp[i][j];
        int res = 0;
        if (w1.charAt(i) == w2.charAt(j))
            return dp[i][j]=solve(i + 1, j + 1, w1, w2, dp);

        res = Math.min(solve(i + 1, j, w1, w2, dp), solve(i, j + 1, w1, w2, dp));
        res = Math.min(res, solve(i + 1, j + 1, w1, w2, dp));
        return dp[i][j] = res + 1;
    }
}
