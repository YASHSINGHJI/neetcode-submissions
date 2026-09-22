class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int length = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
            
        }
        return longest;
    }
}
