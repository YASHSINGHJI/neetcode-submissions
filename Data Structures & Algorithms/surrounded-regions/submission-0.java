class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && ((i == 0 || i == row - 1) || (j == 0 || j == col - 1)))
                    dfs(board, i, j, row, col);
            }

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board, int r, int c, int row, int col) {
        if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(board, r + 1, c, row, col);
        dfs(board, r - 1, c, row, col);
        dfs(board, r, c + 1, row, col);
        dfs(board, r, c - 1, row, col);
    }
}
