package spiralMatrixII;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p/>
 * For example,
 * Given the following matrix:
 * <p/>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int num = 1;
        for (int n1 = 0, n2 = n - 1; n1 <= n2; n1++, n2--) {
            for (int i = n1; i <= n2; i++) {
                matrix[n1][i] = num++;
            }
            for (int i = n1 + 1; i <= n2; i++) {
                matrix[i][n2] = num++;
            }
            if (n2 > n1) {
                for (int i = n2 - 1; i >= n1; i--) {
                    matrix[n2][i] = num++;
                }
                for (int i = n2 - 1; i >= n1 + 1; i--) {
                    matrix[i][n1] = num++;
                }
            }
        }

        return matrix;
    }
}
