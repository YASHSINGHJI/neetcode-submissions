class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        int start = 0;
        int end = heights.length - 1;
        while (start < end) {
            int min = Math.min(heights[start], heights[end]);
            int area = min * (end - start);
            max = Math.max(area, max);
            if(heights[start] == heights[end]) start++;
            else if(heights[start]<heights[end]) start++;
            else end--;
        }
        return max;
    }
}
