class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result=new ArrayList<>();
     backtrack(0,result,new ArrayList<>(),candidates,target);
     return result;   
    }

 private void backtrack(int i,List<List<Integer>> result, List<Integer> cur, int[] nums, int target) {
        if(target==0){
            result.add(new ArrayList<>(cur));
            return;
        }  
        if(i>=nums.length || target<0)
            return;
        cur.add(nums[i]);
        backtrack(i+1, result, cur, nums, target-nums[i]);
        cur.remove(cur.size()-1);        
        while(i+1<nums.length && nums[i+1]==nums[i]){
            i++;
        }
        backtrack(i+1, result, cur, nums, target);
        
 }
}
