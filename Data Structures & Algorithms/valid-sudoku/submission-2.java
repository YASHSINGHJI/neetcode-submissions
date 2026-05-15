class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];
        
        // Initialize HashSets for rows, columns, and squares
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];
                if (current != '.') {
                    int squareIndex = (i / 3)  + (j / 3)*3;  // Calculate square index (0-8)

                    if (rows[i].contains(current) || cols[j].contains(current) || squares[squareIndex].contains(current)) {
                        return false;
                    }

                    // Add the number to the respective sets
                    rows[i].add(current);
                    cols[j].add(current);
                    squares[squareIndex].add(current);
                }
            }
        }
        return true;
    }
}
