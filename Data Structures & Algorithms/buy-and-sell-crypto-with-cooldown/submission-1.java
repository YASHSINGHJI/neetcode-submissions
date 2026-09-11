class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][3];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp);
    }

    public int solve(int index, int buy, int[] prices, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        if (buy == 1) {
            dp[index][buy] = Math.max(-prices[index] + (solve(index + 1, 0, prices, dp)),
                0 + solve(index + 1, 1, prices, dp));
        }
        else
        dp[index][buy] = Math.max(
            prices[index] + (solve(index + 2, 1, prices, dp)), 0 + solve(index + 1, 0, prices, dp));
        return dp[index][buy];
    }
}
