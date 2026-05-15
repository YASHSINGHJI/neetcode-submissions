class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        double[] time = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        for (int i = position.length - 1; i >= 0; i--) {
            time[i] = (double) (target - position[i]) / map.get(position[i]);
            stack.push(time[i]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();

    }
}
