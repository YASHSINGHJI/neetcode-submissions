class Solution {
   public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = s1.length() - 1;
        while (r < s2.length()) {
            for (int i = l; i <= r; i++) {
                map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
            }
            if (map1.equals(map2))
                return true;
            else {
                map2.clear();
                l++;
                r++;
            }
        }
        return false;
    }
}
