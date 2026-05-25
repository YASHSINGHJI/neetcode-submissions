class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int left=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<=prices[left]){
                left=i;
            }
            else{
                ans=Math.max(ans,prices[i]-prices[left]);
            }

        }
        return ans;
                        
    }
}
