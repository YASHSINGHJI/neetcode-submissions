class Solution {
public int characterReplacement(String s, int k) {
    HashMap<Character, Integer> map = new HashMap<>();
    int maxfreq = 0;
    int left = 0;
    int res = 0;
    
    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        map.put(c, map.getOrDefault(c, 0) + 1);
        
        maxfreq = Math.max(maxfreq, map.get(c));
        
        while ((right - left + 1) - maxfreq > k) {
            char lChar = s.charAt(left);
            map.put(lChar, map.get(lChar) - 1);
            left++;
        }
        
        res = Math.max(res, right - left + 1);
    }
    
    return res;
}

      
}
