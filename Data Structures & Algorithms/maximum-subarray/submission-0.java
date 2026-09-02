class Solution {
    public int maxSubArray(int[] nums) {
        //Kadane's algo
        int curSum=0,maxSum=Integer.MIN_VALUE;
        for(int num:nums){
            curSum+=num;
            maxSum=Math.max(curSum,maxSum);
            if(curSum<0){
                curSum=0;
            }
        }
        return maxSum;
    }
}
