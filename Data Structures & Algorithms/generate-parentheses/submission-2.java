class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(res,new StringBuilder(""),0,0,n);
        return res;      
        
    }
    public void backtrack(List<String> res, StringBuilder cur,int open, int close,int n){
        if(open==close && open==n && close==n){
            res.add(cur.toString());
            return;
        }
        if(open<n){
            cur.append('(');
            backtrack(res,cur,open+1,close,n);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            cur.append(')');
            backtrack(res,cur,open,close+1,n);
            cur.deleteCharAt(cur.length()-1);
        }

    }
}
