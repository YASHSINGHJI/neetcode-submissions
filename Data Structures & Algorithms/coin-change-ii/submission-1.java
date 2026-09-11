class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, amount, coins, dp);
    }

    public int solve(int index, int amount, int[] coins, int[][] dp) {
        if (index >= coins.length)
            return 0;

        if (amount == 0) {
            return 1;
        }
        if (dp[index][amount] != -1)
            return dp[index][amount];
        int ans = 0;
        if (coins[index] <= amount) {
            ans += solve(index, amount - coins[index], coins, dp);
        }
        ans += solve(index + 1, amount, coins, dp);
        return dp[index][amount] = ans;
    }
}
