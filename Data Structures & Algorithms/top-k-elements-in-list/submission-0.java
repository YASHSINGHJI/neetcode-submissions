class Solution {
     public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else
                map.put(nums[i], 1);
        }
        for (int key : map.keySet()) {
            int fre = map.get(key);
            if (bucket[fre] == null)
                bucket[fre] = new ArrayList<>();
            bucket[fre].add(key);
        }
        int count=0;
        for(int pos=bucket.length-1; pos>=0 && count<k;pos--){
            if(bucket[pos]!=null){
            for(int i : bucket[pos]){
            res[count++]=i;
        }
        

    }
}
return res;
}
}
