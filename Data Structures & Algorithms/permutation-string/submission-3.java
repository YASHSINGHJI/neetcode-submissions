class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n1 = s1.length();
        char ch[] = s1.toCharArray();
        for (char c : ch) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = s1.length() - 1;
        while (left <= right) {
            map2.put(s2.charAt(left), map2.getOrDefault(s2.charAt(left), 0) + 1);
            left++;
        }
        left = 0;
        right = n1 - 1;
        while (right < s2.length()) {
            if (map1.equals(map2))
                return true;
            map2.put(s2.charAt(left), map2.get(s2.charAt(left)) - 1);
            if (map2.get(s2.charAt(left)) == 0) {
                map2.remove(s2.charAt(left));
            }
            left++;
            right++;
            if (right < s2.length()) {
                map2.put(s2.charAt(right), map2.getOrDefault(s2.charAt(right), 0) + 1);
            }
        }
        return false;

    }
    
}
