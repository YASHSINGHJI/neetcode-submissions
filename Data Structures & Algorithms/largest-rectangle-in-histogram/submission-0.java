class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] ps = prevsmall(heights);
        int[] ns = nextsmall(heights);
        
        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (ns[i] - ps[i] - 1);
            max = Math.max(max, area);
        }
        
        return max;
    }
    
    public int[] prevsmall(int[] heights) {
        int[] ps = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ps[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return ps;
    }
    
    public int[] nextsmall(int[] heights) {
        int[] ns = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            ns[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }
        
        return ns;
    }
}
