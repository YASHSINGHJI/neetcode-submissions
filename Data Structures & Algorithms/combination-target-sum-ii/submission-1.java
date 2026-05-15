class Solution {
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);
    helper(res, new ArrayList<>(), candidates, target, 0);
    return res;
  }

  public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int index) {
    if (target==0) {
      res.add(new ArrayList<>(temp));
      return;
    } 
      for(int i=index;i<nums.length;i++){
        if(i>index && nums[i]==nums[i-1]) continue;
        if(nums[i]>target) break;
        temp.add(nums[i]);
        helper(res, temp, nums, target - nums[i], i + 1);
        temp.remove(temp.size() - 1); // backtrack       
        }
      }    
      
}
