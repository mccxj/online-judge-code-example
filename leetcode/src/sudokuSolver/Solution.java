package sudokuSolver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p/>
 * Empty cells are indicated by the character '.'.
 * <p/>
 * You may assume that there will be only one unique solution.
 */
public class Solution {
    private static final int SIZE = 9;

    public void solveSudoku(char[][] board) {
        solve(0, board);
    }

    private boolean solve(int pos, char[][] board) {
        if (pos == SIZE * SIZE) {
            return true;
        }
        int x = pos / SIZE;
        int y = pos % SIZE;
        if (board[x][y] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[x][y] = (char) ('0' + i);
                if (isValidSudoku(board)) {
                    if (solve(pos + 1, board)) {
                        return true;
                    }
                }
                board[x][y] = '.';
            }
        }
        else {
            if (solve(pos + 1, board)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] pos1 = new boolean[board.length];
            boolean[] pos2 = new boolean[board.length];
            for (int j = 0; j < 9; j++) {
                char c1 = board[i][j];
                char c2 = board[j][i];
                if (!isValid(c1, pos1) || !isValid(c2, pos2)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] pos = new boolean[board.length];
                for (int u = i * 3; u < i * 3 + 3; u++) {
                    for (int v = j * 3; v < j * 3 + 3; v++) {
                        char c = board[u][v];
                        if (!isValid(c, pos)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValid(char c, boolean[] pos) {
        if (c != '.') {
            if (('1' > c || c > '9') || pos[c - '1']) {
                return false;
            }
            pos[c - '1'] = true;
        }
        return true;
    }

    @Test
    public void test() {
        String[] b = {
                "53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = b[i].toCharArray();
        }
        solveSudoku(board);
        assertEquals("534678912", new String(board[0]));
        assertEquals("672195348", new String(board[1]));
        assertEquals("198342567", new String(board[2]));
        assertEquals("859761423", new String(board[3]));
        assertEquals("426853791", new String(board[4]));
        assertEquals("713924856", new String(board[5]));
        assertEquals("961537284", new String(board[6]));
        assertEquals("287419635", new String(board[7]));
        assertEquals("345286179", new String(board[8]));
    }
}
