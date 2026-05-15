class Solution {
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum= -nums[i];
            int start=i+1;
            int end=nums.length-1;
            while (start<end) {
                if (nums[start]+nums[end]==sum) {
                    List<Integer> list = new ArrayList<>();
                    if(set.contains(Arrays.asList(nums[i], nums[start], nums[end]))) {
                        start++;
                        end--;
                        continue;
                    }
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    set.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start<end && nums[start]==nums[start+1]) {
                        start++;
                    }
                    while (start<end && nums[end]==nums[end-1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (nums[start]+nums[end]<sum) {
                    start++;
                } else {
                    end--;
                }                
            }
                       
        }
        return result;

    }
}
