class Solution {
     public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int start = 0;
        int end = s1.length() - 1;
        for (int i = 0; i <= end; i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        while (end < s2.length()) {
            for (int i = start; i <= end; i++) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if (map1.equals(map2)) {
                return true;
            }
            map2.clear();
            start++;
            end++;
        }
        return false;

    }
}
