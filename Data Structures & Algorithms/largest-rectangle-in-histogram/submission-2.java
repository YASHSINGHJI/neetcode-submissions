class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    Stack<Integer> stack = new Stack<>();
    int[] right = new int[n];
    int[] left = new int[n];
    int maxArea = 0;

    // Compute next smaller element index (right boundary)
    for (int i = n - 1; i >= 0; i--) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        right[i] = stack.isEmpty() ? n : stack.peek();  // use n if no smaller element to right
        stack.push(i);
    }

    // Clear stack
    stack.clear();

    // Compute previous smaller element index (left boundary)
    for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
            stack.pop();
        }
        left[i] = stack.isEmpty() ? -1 : stack.peek();  // use -1 if no smaller element to left
        stack.push(i);
    }

    // Compute max area
    for (int i = 0; i < n; i++) {
        int height = heights[i];
        int width = right[i] - left[i] - 1;
        int curArea = height * width;
        maxArea = Math.max(maxArea, curArea);
    }

    return maxArea;
}

}
