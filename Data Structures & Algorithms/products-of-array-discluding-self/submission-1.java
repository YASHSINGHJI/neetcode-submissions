class Solution {
     public int[] productExceptSelf(int[] nums) {

        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = -1, right = nums.length;
            int temp = 1;
            if (i != 0)
                left = i - 1;
            if (i != nums.length - 1)
                right = i + 1;
            while (left >= 0) {
                temp *= nums[left];
                left--;
            }
            while (right <= nums.length - 1) {
                temp *= nums[right];
                right++;
            }
            res[i] = temp;
        }
        return res;
    }
}  
