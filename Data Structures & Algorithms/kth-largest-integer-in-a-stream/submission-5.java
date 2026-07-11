class KthLargest {   
    public int k;
    public int[] nums;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;       
        for(int num:nums){
        pq.offer(num);       
       } 
       while(pq.size()>k){
        pq.poll();
       }
    }
    
    public int add(int val) {        
        pq.offer(val);
        if(pq.size()>k){
            pq.poll();
        }  
        return pq.peek();
    }
}