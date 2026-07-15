class Solution {
public List<List<Integer>> combinationSum(int[] nums, int target) {
     List<List<Integer>> result=new ArrayList<>();
     backtrack(0,result,new ArrayList<>(),nums,target);
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
        backtrack(i, result, cur, nums, target-nums[i]);
        cur.remove(cur.size()-1);
        backtrack(i+1, result, cur, nums, target);
        
 }
}
