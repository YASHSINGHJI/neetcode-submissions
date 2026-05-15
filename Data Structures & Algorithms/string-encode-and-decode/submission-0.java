class Solution {

   public String encode(List<String> strs) {
        String res="";
        for(String s:strs){
            res+=(s.length())+"#"+s;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        int j=0;
        while(j<str.length()){ 
            int i=j;
            while (str.charAt(i)!='#') {
                i++;                
            }
            int length=Integer.parseInt(str.substring(j,i));   
            res.add(str.substring(i+1,i+1+length));  
            j=i+1+length;     
        }
        return res;
    }
}
