class Solution {
        public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxleft = height[left];
        int maxright = height[right];
        int ans = 0;
        while (left < right) {
            if (maxleft < maxright) {
                left++;
                maxleft = Math.max(maxleft, height[left]);
                ans+=maxleft - height[left];

            } else {
                right--;
                maxright = Math.max(maxright, height[right]);
                ans+=maxright-height[right];
            }
        }
        return ans;
    }
}
