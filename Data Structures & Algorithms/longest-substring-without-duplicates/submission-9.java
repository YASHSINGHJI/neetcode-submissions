class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(l));
                l++;
            }

            max = Math.max(max, i - l + 1);

            set.add(s.charAt(i));
        }
        return max;

    }
}