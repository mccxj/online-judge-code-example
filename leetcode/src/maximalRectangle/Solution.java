package maximalRectangle;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Solution {
    // similar as problem largest-rectangle-in-histogram.
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length + 1;
        int[][] m = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            Stack<Integer> poses = new Stack<Integer>();
            poses.add(0);
            m[i][col - 1] = 0;
            for (int j = 0; j < col; j++) {
                if (j < col - 1 && matrix[i][j] != '0') {
                    m[i][j] = (i == 0 ? 1 : m[i - 1][j] + 1);
                }

                if (j >= 1) {
                    int h = m[i][j];
                    while (!poses.isEmpty() && h <= m[i][poses.peek()]) {
                        int pos = poses.pop();
                        int rect = m[i][pos] * (j - pos);

                        if (poses.isEmpty()) {
                            rect += m[i][pos] * pos;
                        } else {
                            rect += m[i][pos] * (pos - poses.peek() - 1);
                        }

                        if (rect > max) {
                            max = rect;
                        }
                    }
                    poses.add(j);
                }
            }
        }
        return max;
    }
}