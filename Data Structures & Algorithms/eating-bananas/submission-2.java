class Solution {
   public int minEatingSpeed(int[] piles, int h) {
    Arrays.sort(piles);
    int end=piles[piles.length-1];
    int start=1;
    int min=1;
    while (start<=end) {
        int mid=(start+end)/2;
        int temp=0;
        for(int pile:piles){
             temp+=Math.ceil((double)pile/mid);
            }            
            if(temp<=h){
               min=mid;
               end=mid-1;
            }
            else{
                start=mid+1;
            }                        
    }
    return min;
        
    }
}
