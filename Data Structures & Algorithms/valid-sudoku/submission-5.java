class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set1.contains(board[i][j]))
                    return false;
                set1.add(board[i][j]);
            }
            set1.clear();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (set2.contains(board[j][i]))
                    return false;
                set2.add(board[j][i]);
            }
            set2.clear();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = i * 3; k <= (i * 3) + 2; k++) {
                    for (int l = j * 3; l <= (j * 3) + 2; l++) {
                        if (board[k][l] == '.')
                            continue;
                        if (set3.contains(board[k][l]))
                            return false;
                        set3.add(board[k][l]);
                    }
                }
                set3.clear();
            }
        }
        return true;
    }
}
