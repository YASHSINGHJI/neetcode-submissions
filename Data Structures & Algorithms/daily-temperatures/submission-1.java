class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length-1; i++) {
            int count=0;
            int left=i;
            int right=i+1;
            while(right!=temperatures.length){
                if(temperatures[left]<temperatures[right]){
                    count++;
                    result[i]=count;
                    break;
                }
                else{
                    result[i]=0;
                    count++;
                    right++;
                }
            }            
        }
        return result;

    }
}
