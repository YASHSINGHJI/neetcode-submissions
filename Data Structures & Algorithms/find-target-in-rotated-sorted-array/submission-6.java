class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int pivot2 = pivot;
        int start = 0;
        while (start <= pivot) {
            int mid = (start + pivot) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                pivot = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        start = pivot2 + 1;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
