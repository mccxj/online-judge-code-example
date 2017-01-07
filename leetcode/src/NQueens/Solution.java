package NQueens;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p/>
 * <p/>
 * <p/>
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p/>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * <p/>
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * <p/>
 * [
 * [".Q..",  // Solution 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p/>
 * ["..Q.",  // Solution 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 */
public class Solution {
    private List<String[]> queens = new ArrayList<String[]>();
    private int[] pos;

    public List<String[]> solveNQueens(int n) {
        if (n <= 0) {
            return queens;
        }

        pos = new int[n];
        solveNQueens(0, n);
        return queens;
    }

    private void solveNQueens(int p, int n) {
        if (p == n) {
            String[] rows = new String[n];
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(n);
                for (int j = 0; j < n; j++) {
                    sb.append(j != pos[i] ? '.' : 'Q');
                }
                rows[i] = sb.toString();
            }
            queens.add(rows);
            return;
        }

        for (int i = 0; i < n; i++) {
            pos[p] = i;

            boolean ok = true;
            for (int j = 0; j < p; j++) {
                if (pos[j] == pos[p] || p - j == pos[j] - pos[p] || p - j == pos[p] - pos[j]) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                solveNQueens(p + 1, n);
            }
        }
    }
}
