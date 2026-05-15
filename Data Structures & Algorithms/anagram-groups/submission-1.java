public class Solution {
       public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
       HashMap<String, List<String>> map = new HashMap<>(); 
        for (String str : strs) {
            String temp=str;
            char [] ch=str.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if(!map.containsKey(sorted))
            map.put(sorted,new ArrayList<>());
            map.get(sorted).add(temp);
        }
        for(String key:map.keySet()){
            res.add(map.get(key));
        }
        return res;
    }
}