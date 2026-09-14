class Solution {
    public int hammingWeight(int n) {
        int res=0;
        int bitmask=1;
        for(int i=1;i<=32;i++){
            if((n & bitmask)>0) res++;
         bitmask=1<<i;
        }
        return res;
    }

}
