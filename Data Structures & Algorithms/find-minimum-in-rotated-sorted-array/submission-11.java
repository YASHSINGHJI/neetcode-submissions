class Solution {
    public int findMin(int[] nums) {
        if(nums.length<=1) return nums[0];
        return Math.min(nums[0], nums[findPivot(nums) + 1]);
    }
    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else
                end = mid;
        }
        return start;
    }
}
