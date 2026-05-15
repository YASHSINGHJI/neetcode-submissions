class Solution {
        public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxleft = height[left];
        int maxright = height[right];
        int ans = 0;
        while (left < right) {
            maxleft = Math.max(maxleft, height[left]);
            maxright = Math.max(maxright, height[right]);
            if (maxleft < maxright) {
                ans+=maxleft - height[left];
                left++;                
                

            } else {              
                ans+=maxright-height[right];
                right--;
            }
        }
        return ans;
    }
}
