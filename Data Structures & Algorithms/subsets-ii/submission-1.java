class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums, int i) {
        if (i == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        backtrack(result, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
        while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
            i++;
        }
        backtrack(result, temp, nums, i + 1);
    }
}
