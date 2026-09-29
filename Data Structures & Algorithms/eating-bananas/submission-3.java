class Solution {
        public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1, r = piles[piles.length - 1];
        int res = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            int temp = 0;
            for (int pile : piles) {
                temp += Math.ceil((double) pile / mid);
            }
            if (temp <= h) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else
                l = mid + 1;

        }
        return res;
    }

}