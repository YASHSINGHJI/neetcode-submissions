class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, 0);
        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, int i) {
        if (i == nums.length) {
            // Correctly convert primitive int[] to List<Integer>
            List<Integer> current = new ArrayList<>();
            for (int num : nums) {
                current.add(num);
            }
            result.add(current);
            return;
        }

        for (int idx = i; idx < nums.length; idx++) {
            swap(nums, i, idx);          // Pass the array reference and indexes
            backtrack(nums, result, i + 1);
            swap(nums, i, idx);          // Undo the swap (backtrack)
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}