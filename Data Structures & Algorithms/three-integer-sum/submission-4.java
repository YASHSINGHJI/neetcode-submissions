class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < nums.length && start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> tem = new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end]));
                    Collections.sort(tem);
                    set.add(tem);
                    start++;
                    end--;
                } else if (sum > 0)
                    end--;
                else
                    start++;
            }
        }
        res.addAll(set);
        return res;
    }
}