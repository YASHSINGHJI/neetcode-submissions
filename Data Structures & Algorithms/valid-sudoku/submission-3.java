class Solution {
       public boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> col = new HashSet<>();
        HashSet<Character> box = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (col.contains(board[i][j]))
                        return false;
                    col.add(board[i][j]);
                }

            }
            col.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    if (row.contains(board[j][i]))
                        return false;
                    row.add(board[j][i]);
                }

            }
            row.clear();
        }
        for (int i = 0; i < 3; i++) {
            for (int z = 0; z < 3; z++) {
                for (int j = 3 * i; j <= (3 * i) + 2; j++) {
                    for (int k = 3 * z; k <= (3 * z) + 2; k++) {
                        if (board[j][k] != '.') {
                            if (box.contains(board[j][k]))
                                return false;
                            box.add(board[j][k]);
                        }
                    }
                }
                box.clear();
            }

        }
        for (int i = 0; i < 3; i++) {
            for (int z = 0; z < 3; z++) {
                for (int j = 3 * i; j <= (3 * i) + 2; j++) {
                    for (int k = 3 * z; k <= (3 * z) + 2; k++) {
                        if (board[k][j] != '.') {
                            if (box.contains(board[k][j]))
                                return false;
                            box.add(board[k][j]);
                        }
                    }
                }
                box.clear();
            }

        }
        return true;
    }
}
