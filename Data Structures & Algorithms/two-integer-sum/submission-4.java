class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int new_target = target - nums[i];
            if (map.containsKey(new_target)) {
                return new int[] { map.get(new_target), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { 0, 0 };
    }
}
