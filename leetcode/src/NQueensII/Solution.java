package NQueensII;

/**
 * Follow up for N-Queens problem.
 * <p/>
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class Solution {
    private int[] pos;
    private int total = 0;

    public int totalNQueens(int n) {
        if (n <= 0) {
            return total;
        }

        pos = new int[n];
        totalNQueens(0, n);
        return total;
    }

    private void totalNQueens(int p, int n) {
        if (p == n) {
            total++;
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
                totalNQueens(p + 1, n);
            }
        }
    }
}
