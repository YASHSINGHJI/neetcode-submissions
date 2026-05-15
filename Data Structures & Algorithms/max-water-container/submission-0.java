class Solution {
      public int maxArea(int[] heights) {
        int start = 0;
        int end=heights.length-1;
        int maxArea = 0;
        while(start<end){
            int area = Math.min(heights[start],heights[end])*(end-start);
            maxArea = Math.max(maxArea,area);
            if(heights[start]<heights[end]){
                start++;
            }else{
                end--;
            }    

    }
    return maxArea;

    }
}
