class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list = new ArrayList<>();
        helper(nums, target, 0, new ArrayList<>());
        return list;
    }
    public void helper(int[] nums, int target, int i, List<Integer> temp) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        if (i >= nums.length || target < 0)
            return;

        temp.add(nums[i]);
        helper(nums, target - nums[i], i, temp);
        temp.remove(temp.size() - 1);
        helper(nums, target, i + 1, temp);
    }
}
