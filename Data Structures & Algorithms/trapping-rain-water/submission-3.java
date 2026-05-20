class Solution {

    public int trap(int[] height) {
        int water = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (max_left - height[left] > 0)
                    water += max_left - height[left];
                max_left = Math.max(max_left, height[left]);
                left++;
            } else {
                if (max_right - height[right] > 0)
                    water += max_right - height[right];
                max_right = Math.max(max_right, height[right]);
                right--;
            }
        }
        return water;
    }
}

