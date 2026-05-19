class Solution {
   public List<List<Integer>> threeSum(int[] nums) {

    Arrays.sort(nums);

    List<List<Integer>> list = new ArrayList<>();

    HashSet<List<Integer>> set = new HashSet<>();

    for (int i = 0; i < nums.length - 2; i++) {

        int start = i + 1;
        int end = nums.length - 1;

        while (start < end) {

            int sum = nums[i] + nums[start] + nums[end];

            if (sum == 0) {

                List<Integer> sub_list =
                        Arrays.asList(nums[i], nums[start], nums[end]);

                if (!set.contains(sub_list)) {

                    set.add(sub_list);
                    list.add(sub_list);
                }

                start++;
                end--;

            } else if (sum < 0) {

                start++;

            } else {

                end--;
            }
        }
    }

    return list;
}
}
