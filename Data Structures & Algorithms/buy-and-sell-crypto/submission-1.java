class Solution {
     public int maxProfit(int[] prices) {
        int minbuy = Integer.MAX_VALUE;
        int maxsell = Integer.MIN_VALUE;
        for (int i = 0; i + 1 < prices.length; i++) {
            int buy = prices[i];
            int sell = prices[i + 1];
            minbuy = Math.min(buy, minbuy);
            maxsell = Math.max(maxsell, sell - minbuy);

        }
        if (maxsell < 0)
            return 0;
        return maxsell;

    }
       
}
        