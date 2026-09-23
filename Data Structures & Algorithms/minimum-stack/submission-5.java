class MinStack {
    private Stack<Integer> nor;
    private Stack<Integer> min;

    public MinStack() {
        nor = new Stack<>();
        min = new Stack<>();
    }

    public void push(int value) {
        nor.push(value);
        if (min.isEmpty()) {
            min.push(value);
            return;
        }
        if (nor.peek() <= min.peek()) {
            min.push(value);
        }
    }

    public void pop() {
        int val = nor.pop();
        if (!min.isEmpty() && (val == min.peek())) {
            min.pop();
        }
    }

    public int top() {
        return nor.peek();
    }

    public int getMin() {
        if (!min.isEmpty())
            return min.peek();
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */