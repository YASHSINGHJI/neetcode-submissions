class Solution {
       public int maxProfit(int[] prices) {
        int profit = 0;
        int maxprofit = profit;
        int start = 0;

        while (start < prices.length - 1) {
            int end = start + 1;
            while (end < prices.length) {
                if (prices[end] > prices[start]) {
                    profit = prices[end] - prices[start];
                    if (profit > maxprofit) {
                        maxprofit = profit;
                    }
                   

                }
                end++;

            }
            start++;

        }
        return maxprofit;

    }
}
