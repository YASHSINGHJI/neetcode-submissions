class Solution {
       public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

 private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);
        current.remove(current.size() - 1);
        
        while( index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        backtrack(nums, index+1, current, result);
    }
}
