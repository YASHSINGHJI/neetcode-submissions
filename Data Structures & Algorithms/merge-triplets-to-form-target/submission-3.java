class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for (int i = 0; i < target.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < triplets.length; j++) {
                if (triplets[j][0] > target[0] || triplets[j][1] > target[1]
                    || triplets[j][2] > target[2]) {
                    continue;
                }
                max = Math.max(max, triplets[j][i]);
            }
            if (target[i] != max) {
                return false;
            }
        }
        return true;
    }
}
