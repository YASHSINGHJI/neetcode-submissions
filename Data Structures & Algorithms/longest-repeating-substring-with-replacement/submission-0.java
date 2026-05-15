class Solution {
        public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int end = 0; end < s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0) + 1);
            int max = Collections.max(map.values());
            while (end - start + 1 - max > k) {
                map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                start++;
            }
            res = Math.max(res, end - start + 1);
        }

        return res;

    }
}
