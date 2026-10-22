class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        helper(nums, 0, new ArrayList<>());
        return res;
    }
    public void helper(int[] nums, int i, List<Integer> temp) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(nums, i + 1,temp);
        temp.remove(temp.size()-1);
        helper(nums, i + 1, temp);
    }
}
