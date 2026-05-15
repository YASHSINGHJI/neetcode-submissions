class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    helper(res, new ArrayList<>(), candidates, target, 0, 0);
    return res;
  }

  public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int total, int i) {
    if (total == target) {
      res.add(new ArrayList<>(temp));
      return;
    }
    if (total > target || i == nums.length)
      return;
    // include
    temp.add(nums[i]);
    helper(res, temp, nums, target, total + nums[i], i + 1);
    temp.remove(temp.size() - 1); // backtrack
    // exclude
     while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
   
    helper(res, temp, nums, target, total, i + 1);
  }
      
}
