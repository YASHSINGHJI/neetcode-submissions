class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                int n = Integer.parseInt(stack.pop());
                n += Integer.parseInt(stack.pop());
                stack.push(Integer.toString(n));

            } else if (token.equals("-")) {
                int n = Integer.parseInt(stack.pop());
                int x = Integer.parseInt(stack.pop());
                int t = x - n;
                stack.push(Integer.toString(t));

            } else if (token.equals("*")) {
                int n = Integer.parseInt(stack.pop());
                n *= Integer.parseInt(stack.pop());
                stack.push(Integer.toString(n));

            } else if (token.equals("/")) {
                int n = Integer.parseInt(stack.pop());
                int x = Integer.parseInt(stack.pop());
                int t = x / n;
                stack.push(Integer.toString(t));

            } else
                stack.push(token);
        }
        return Integer.parseInt(stack.peek());
    }
}
