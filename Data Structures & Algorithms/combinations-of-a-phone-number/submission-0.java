class Solution {
      public List<String> letterCombinations(String digits) {
    List<String> res=new ArrayList<>();
   HashMap<Character,String> map=new HashMap<>();
   map.put('2',"abc");
   map.put('3',"def");
   map.put('4',"ghi");
   map.put('5',"jkl");
   map.put('6',"mno");
   map.put('7',"pqrs");
   map.put('8',"tuv");
   map.put('9',"wxyz");  
  if(!digits.isEmpty())
  backtrack(res,digits, 0,"",map);
  return res;      
  }
  public void backtrack(List<String> res,String digits, int index,String curString,HashMap<Character,String> map){
    if(curString.length()==digits.length()){
      res.add(curString);
      return;
    }    
    for(char ch:map.get(digits.charAt(index)).toCharArray()){
      backtrack(res, digits, index+1, curString+ch, map);
    } 

  }

}
