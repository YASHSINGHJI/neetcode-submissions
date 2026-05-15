class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            map.put(num, true);
        }
        for (int num : nums) {
            int length = 1;
            int next = num + 1;
            while(map.containsKey(next) && map.get(next)==true){
                length++;
                map.put(next, false);
                next++;
            }
            int prev = num - 1;
            while(map.containsKey(prev) && map.get(prev)==true){
                length++;
                map.put(prev, false);
                prev--;
            }
            longest = Math.max(longest, length);
        }
        return longest;

    }
}
