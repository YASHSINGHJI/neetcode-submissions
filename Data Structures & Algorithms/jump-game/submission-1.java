class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int i=n-2,goal=n-1;
        while(i>=0){
            if(i+nums[i]>=goal){
                goal=i;
            }
            i--;
        }
        if(goal==0){
            return true;
        }
        return false;
        
    }
}
