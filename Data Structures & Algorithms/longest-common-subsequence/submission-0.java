class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solveMem(0, 0, text1, text2, dp);
    }
    public int solveMem(int i, int j, String t1, String t2, int[][] dp) {
        if (i == t1.length())
            return 0;
        if (j == t2.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (t1.charAt(i) == t2.charAt(j))
            dp[i][j] = 1 + solveMem(i + 1, j + 1, t1, t2, dp);
        else
            dp[i][j] = Math.max(solveMem(i + 1, j, t1, t2, dp), solveMem(i, j + 1, t1, t2, dp));
        return dp[i][j];
    }
}
