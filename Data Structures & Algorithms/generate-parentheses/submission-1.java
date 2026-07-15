class Solution {
    public List<String> generateParenthesis(int n) {
    List<String> list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    backtrack(list,sb,n,0,0);
    return list;        
    }
    public void backtrack(List<String> list,StringBuilder sb,int n,int open,int close){
        if(open==close && open==n && close==n){
            list.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("(");
            backtrack(list, sb, n, open+1, close);
            sb.deleteCharAt(sb.length()-1);             
        }
        if(close<open){
            sb.append(")");
            backtrack(list, sb, n, open, close+1);
            sb.deleteCharAt(sb.length()-1);             
        }


    }
}
