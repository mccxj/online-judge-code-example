package uniquePaths;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p/>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p/>
 * How many possible unique paths are there?
 * <p/>
 * <p/>
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * <p/>
 * Note: m and n will be at most 100.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int[][] paths = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            paths[i][1] = 1;
        }
        for (int i = 1; i <= n; i++) {
            paths[1][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m][n];
    }

    @Test
    public void test() {
        assertEquals(1, uniquePaths(2, 1));
        assertEquals(1, uniquePaths(1, 2));
        assertEquals(2, uniquePaths(2, 2));
        assertEquals(3, uniquePaths(2, 3));
        assertEquals(6, uniquePaths(3, 3));
    }
}
