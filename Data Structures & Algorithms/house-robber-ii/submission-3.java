class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        int helper1 = helper(Arrays.copyOfRange(nums, 0, nums.length - 1), nums.length - 1);
        int helper2 = helper(Arrays.copyOfRange(nums, 1, nums.length), nums.length - 1);
        return Math.max(helper1, helper2);
    }
    public int helper(int[] nums, int n) {
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
}
