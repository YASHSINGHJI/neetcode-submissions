class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == row - 1) || (j == 0 || j == col - 1)) {
                    capture(i, j, board, row, col);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void capture(int i, int j, char[][] board, int row, int col) {
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        capture(i + 1, j, board, row, col);
        capture(i, j + 1, board, row, col);
        capture(i, j - 1, board, row, col);
        capture(i - 1, j, board, row, col);
    }
}
