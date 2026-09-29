class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int piv = findPivot(nums, 0, nums.length - 1) - 1;
        int piv2 = piv + 1;
        int e = nums.length - 1;
        while (s <= piv) {
            int mid = (s + piv) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                piv = mid - 1;
            else
                s = mid + 1;
        }
        while (piv2 <= e) {
            int mid = (e + piv2) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                e = mid - 1;
            else
                piv2 = mid + 1;

        }
        return -1;

    }

    public int findPivot(int[] nums, int s, int e) {
        while (s < e) {
            int mid = (s + e) / 2;
            if (nums[mid] > nums[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }
}