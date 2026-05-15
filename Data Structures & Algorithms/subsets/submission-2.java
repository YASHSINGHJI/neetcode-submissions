

class Solution {
      List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(res,nums, 0, new ArrayList<>());
        return res;
    }

    public void helper(List<List<Integer>> res,int[] nums, int index, List<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res,nums, i+1, temp);
            temp.remove(temp.size()-1);
        }

    }
}


