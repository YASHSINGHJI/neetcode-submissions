class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(nums, target, 0, 0, dp);
    }
    public int solve(int[] nums, int target, int index, int sum, Map<String, Integer> dp) {
        if (index == nums.length)
            return sum == target ? 1 : 0;
         String key = index + "," + sum;
        if (dp.containsKey(key))
            return dp.get(key);

        int add = solve(nums, target, index + 1, sum + nums[index], dp);
        int sub = solve(nums, target, index + 1, sum - nums[index], dp);
        dp.put(key, add + sub);
        return add + sub;
    }
}
