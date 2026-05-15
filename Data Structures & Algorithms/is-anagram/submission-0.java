class Solution {
       public boolean isAnagram(String s, String t) {
        HashMap<Character , Integer> set = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
            for (int i = 0; i < s.length(); i++) {
                if(set.containsKey(s.charAt(i)))
                set.put(s.charAt(i),set.get(s.charAt(i))+1);
                else
                set.put(s.charAt(i),1);                             
            }
            for (int i = 0; i < t.length(); i++) {
                if(set.containsKey(t.charAt(i)))
                set.put(t.charAt(i),set.get(t.charAt(i))-1);
                else
                return false;                
            }
            for(char key : set.keySet()){
                if(set.get(key)!=0) return false;
            }
        
        return true;
    
    }
}
