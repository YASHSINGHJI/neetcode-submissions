class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Required frequency
        for (char ch : t.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // Window frequency
        for (char ch : t.toCharArray()) {
            map2.put(ch, 0);
        }

        int l = 0;
        int have = 0;
        int need = map1.size();

        int[] res = new int[] {-1, -1};
        int resLen = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {

            if (map2.containsKey(s.charAt(r))) {

                map2.put(
                    s.charAt(r),
                    map2.get(s.charAt(r)) + 1
                );

                if (map2.get(s.charAt(r)).equals(map1.get(s.charAt(r)))) {
                    have++;
                }
            }

            while (have == need) {

                if (r - l + 1 < resLen) {
                    res = new int[] {l, r};
                    resLen = r - l + 1;
                }

                if (map2.containsKey(s.charAt(l))) {
                    map2.put(
                        s.charAt(l),
                        map2.get(s.charAt(l)) - 1
                    );
                }

                if (map1.containsKey(s.charAt(l))
                    && map2.get(s.charAt(l)) < map1.get(s.charAt(l))) {

                    have--;
                }

                l++;
            }
        }

        if (resLen != Integer.MAX_VALUE) {
            return s.substring(res[0], res[1] + 1);
        }

        return "";
    }
}