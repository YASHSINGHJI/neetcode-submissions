class Solution {
     public int minEatingSpeed(int[] piles, int h) {
        int k = 1, s = 0;
        int index = 0;
        while (index < piles.length) {
            s += Math.ceil((double)piles[index] / k);
            if (s > h) {
                k++;
                s = 0;
                index = -1;
            }
            index++;

        }

        return k;
    }

}
