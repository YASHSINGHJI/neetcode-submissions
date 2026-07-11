class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            pq.offer(stone);
        }
        while (pq.size()>1) {
            int p=pq.poll();
            int q=pq.poll();
            int ans=Math.abs(p-q);
            pq.offer(ans);            
        }
        return pq.peek();
        
    }
}
