class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] pair = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = (target - position[i])*1.0 / speed[i];
        }
        Stack<Double> stack = new Stack<>();
        Arrays.sort(pair, (a, b) -> Double.compare(a[0], b[0]));
        for (int i = pair.length - 1; i >= 0; i--) {
            double time = pair[i][1];
            stack.push(time);
            while (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();

            }

        }
        return stack.size();

    }
}