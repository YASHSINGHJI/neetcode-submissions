class Solution {
    public int[] topKFrequent(int[] nums, int k) {

    HashMap<Integer, Integer> freqMap = new HashMap<>();

    // Count frequency
    for (int num : nums) {
        freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }

    // Max Heap based on frequency
    PriorityQueue<Integer> pq =
            new PriorityQueue<>((a,b)->freqMap.get(b)-freqMap.get(a));

    // Add all keys
    pq.addAll(freqMap.keySet());

    int[] result = new int[k];

    // Take top k
    for (int i = 0; i < k; i++) {
        result[i] = pq.poll();
    }

    return result;
}
}
