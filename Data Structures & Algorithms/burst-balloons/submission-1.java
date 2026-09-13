class Solution {

    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        return solve(1, n, arr, dp);
    }

    public int solve(int left, int right,
                     int[] nums, int[][] dp) {

        if (left > right) {
            return 0;
        }

        if (dp[left][right] != 0) {
            return dp[left][right];
        }

        int ans = 0;

        for (int k = left; k <= right; k++) {

            int coins =
                nums[left - 1] * nums[k] * nums[right + 1];

            int leftCoins =
                solve(left, k - 1, nums, dp);

            int rightCoins =
                solve(k + 1, right, nums, dp);

            ans = Math.max(
                ans,
                coins + leftCoins + rightCoins
            );
        }

        return dp[left][right] = ans;
    }
}