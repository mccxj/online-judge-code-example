package wordSearch;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p/>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p/>
 * For example,
 * Given board =
 * <p/>
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
public class Solution {
    private static final int[][] pox = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private char[][] board;
    private String word;
    private boolean[][] used;
    private int row;
    private int col;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        this.board = board;
        this.word = word;
        this.row = board.length;
        this.col = board[0].length;
        this.used = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                used[i][j] = false;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    used[i][j] = true;
                    if (exist(1, i, j)) {
                        return true;
                    }
                    used[i][j] = false;
                }
                used[i][j] = false;
            }
        }
        return false;
    }

    private boolean exist(int pos, int x, int y) {
        if (pos == word.length()) {
            return true;
        }

        for (int[] p : pox) {
            int nx = x + p[0];
            int ny = y + p[1];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !used[nx][ny] && board[nx][ny] == word.charAt(pos)) {
                used[nx][ny] = true;
                if (exist(pos + 1, nx, ny)) {
                    return true;
                }
                used[nx][ny] = false;
            }
        }
        return false;
    }

    @Test
    public void test() {
        char[][] board = {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
        assertTrue(exist(board, "ABCCED"));
        assertTrue(exist(board, "SEE"));
        assertTrue(!exist(board, "ABCB"));
    }
}

