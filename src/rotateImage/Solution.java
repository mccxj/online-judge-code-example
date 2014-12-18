package rotateImage;

/**
 * You are given an n x n 2D matrix representing an image.
 * <p/>
 * Rotate the image by 90 degrees (clockwise).
 * <p/>
 * Follow up:
 * Could you do this in-place?
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 1) {
            return;
        }

        int n = matrix.length;
        int ni = n / 2;
        int nj = n / 2;
        if (n % 2 != 0) {
            nj += 1;
        }

        for (int i = 0; i < ni; i++) {
            for (int j = 0; j < nj; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = t;
            }
        }
    }
}
