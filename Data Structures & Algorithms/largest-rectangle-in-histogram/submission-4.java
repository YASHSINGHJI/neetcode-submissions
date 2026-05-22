class Solution {
    public int largestRectangleArea(int[] heights) {
        int ans = 0;
        int right_small[] = new int[heights.length];
        int left_small[] = new int[heights.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right_small[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < heights.length; i++) {
            while (stack.size() > 0 && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left_small[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int temp = heights[i] * (right_small[i] - left_small[i] - 1);
            ans = Math.max(ans, temp);
        }
        return ans;

    }
}
