class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : nums) {
            priorityQueue.offer(i);
        }
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();

    }
}
