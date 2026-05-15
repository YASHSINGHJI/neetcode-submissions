class Solution {
      public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    helper(res, new ArrayList<>(), nums, target, 0);
    return res;
  }

  Set<List<Integer>> set = new HashSet<>();

  public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int index) {
    if (target < 0 || index == nums.length)
      return;

    if (target == 0) {
      if (!set.contains(temp)) {
        res.add(new ArrayList<>(temp));
        set.add(temp);
      }
      return;
    }

    temp.add(nums[index]);
    helper(res, temp, nums, target - nums[index], index + 1);
    helper(res, temp, nums, target - nums[index], index);
    temp.remove(temp.size() - 1); // backtrack
    helper(res, temp, nums, target, index + 1);

  }
}
