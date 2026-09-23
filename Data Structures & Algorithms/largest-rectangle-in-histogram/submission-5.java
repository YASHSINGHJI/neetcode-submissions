class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>(); // [index,height]
        int max = 0;
        int start = 0;
        for (int i = 0; i < heights.length; i++) {
            start = i;
            while (stack.size() > 0 && stack.peek()[1] > heights[i]) {
                int[] pop = stack.pop();
                max = Math.max(max, pop[1] * (i - pop[0]));
                start = pop[0];
            }
            stack.push(new int[] { start, heights[i] });
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            max = Math.max(max, pop[1] * (heights.length - pop[0]));
        }
        return max;
    }
}