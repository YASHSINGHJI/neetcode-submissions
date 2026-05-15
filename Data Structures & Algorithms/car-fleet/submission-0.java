class Solution {
     public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        double[] time = new double[position.length];
        for (int i = 0; i < position.length; i++) {
            time[i] = (double)(target - position[i]) / map.get(position[i]);
        }
        int count = 0;
        double max = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            if (time[i] > max) {
                max = time[i];
                count++;
            }
        }
        return count;


    }
}
