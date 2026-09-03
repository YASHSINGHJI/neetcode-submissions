class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    int totGas = Arrays.stream(gas).sum();
    int totCost = Arrays.stream(cost).sum();
    int start=0;
    int curGas=0;
    if(totGas<totCost)
    return -1;
    for(int i=0;i<gas.length;i++){
        curGas+=gas[i]-cost[i];
        if(curGas<0){
            start=i+1;
            curGas=0;
        }
    }
    return start;

        
    }
}
