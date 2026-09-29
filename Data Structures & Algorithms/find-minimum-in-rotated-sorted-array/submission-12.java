class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (nums[mid] >= nums[e] && nums[s] > nums[e])
                s = mid+1;
            else if(nums[s] > nums[e])
                e = mid;
            else
                e=mid-1;
        }
        return nums[s];
    }
}