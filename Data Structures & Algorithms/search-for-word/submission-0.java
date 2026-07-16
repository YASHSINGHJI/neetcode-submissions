class Solution {
  public boolean exist(char[][] board, String word) {
    int row=board.length;
    int col=board[0].length;
    boolean[][] vis=new boolean[board.length][board[0].length];
    for(int r=0;r<row;r++){
        for(int c=0;c<col;c++){
            if(backtrack(board,word,0,r,c,vis)) return true;
        }
    }
    return false;            
    }
    public boolean backtrack(char[][] board,String word,int index,int r,int c,boolean[][] vis){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length 
            || word.charAt(index)!=board[r][c] || vis[r][c]==true){
                return false;            
            }
        if(index==word.length()-1)
                return true;
    vis[r][c]=true;
    boolean res=backtrack(board, word,index+1,r+1,c,vis) || backtrack(board, word,index+1,r-1,c,vis)
    || backtrack(board, word,index+1,r,c+1,vis) || backtrack(board, word,index+1,r,c-1,vis);
    vis[r][c]=false;
    return res;
    }
}
