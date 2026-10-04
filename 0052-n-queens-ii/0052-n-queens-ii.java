class Solution {
    public void backtrack(
        int row,
        List<List<String>> boards,
        Set<Integer> cols,
        Set<Integer> diags,
        Set<Integer> antiDiags,
        int n,
        char[][] game
    ) {
        if (row == n) {
            List<String> result = new ArrayList<>();

            for (char[] r : game) {
                result.add(new String(r));
            }

            boards.add(result);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col)) continue;

            int diag = row - col;
            int antiDiag = row + col;

            if (diags.contains(diag) || antiDiags.contains(antiDiag)) continue;

            cols.add(col);
            diags.add(diag);
            antiDiags.add(antiDiag);

            game[row][col] = 'Q';
            backtrack(row + 1, boards, cols, diags, antiDiags, n, game);

            cols.remove(col);
            diags.remove(diag);
            antiDiags.remove(antiDiag);

            game[row][col] = '.';
        }
    }

    public int totalNQueens(int n) {
        List<List<String>> boards = new ArrayList<>();

        Set<Integer> cols = new HashSet<>();
        Set<Integer> diags = new HashSet<>();
        Set<Integer> antiDiags = new HashSet<>();

        char[][] game = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                game[i][j] = '.';
            }
        }

        backtrack(0, boards, cols, diags, antiDiags, n, game);

        return boards.size();
    }
}