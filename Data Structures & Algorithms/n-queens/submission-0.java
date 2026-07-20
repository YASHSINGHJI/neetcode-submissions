class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.'); 
        }

        backtrack(res, new ArrayList<>(), board, n, 0);
        return res;
    }

    public void backtrack(
        List<List<String>> res, List<String> cur, char[][] board, int n, int row) {
        if (row == n) {
            List<String> copy = new ArrayList<>();
            for (char[] i : board) {
                copy.add(new String(i));
            }
            res.add(copy);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j, n)) {
                board[row][j] = 'Q';
                backtrack(res, cur, board, n, row + 1);
                board[row][j] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int j, int n) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row, col = j; i >= 0 && col >= 0; i--, col--) {
            if (board[i][col] == 'Q')
                return false;
        }
        for (int i = row, col = j; i >= 0 && col < n; i--, col++) {
            if (board[i][col] == 'Q')
                return false;
        }
        return true;
    }
}
