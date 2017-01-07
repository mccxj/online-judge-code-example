package validSudoku;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p/>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * <p/>
 * <p/>
 * A partially filled sudoku which is valid.
 * <p/>
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution {
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
                ".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = b[i].toCharArray();
        }
        assertTrue(isValidSudoku(board));
    }
}
