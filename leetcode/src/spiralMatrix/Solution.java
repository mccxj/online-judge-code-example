package spiralMatrix;

import java.util.ArrayList;
import java.util.List;

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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<Integer>();

        int m = matrix.length;
        if (m == 0 || matrix[0].length == 0) {
            return nums;
        }

        int n = matrix[0].length;
        for (int m1 = 0, m2 = m - 1, n1 = 0, n2 = n - 1; m1 <= m2 && n1 <= n2; m1++, m2--, n1++, n2--) {
            for (int i = n1; i <= n2; i++) {
                nums.add(matrix[m1][i]);
            }
            for (int i = m1 + 1; i <= m2; i++) {
                nums.add(matrix[i][n2]);
            }
            if (m2 > m1) {
                for (int i = n2 - 1; i >= n1; i--) {
                    nums.add(matrix[m2][i]);
                }
            }
            if (n2 > n1) {
                for (int i = m2 - 1; i >= m1 + 1; i--) {
                    nums.add(matrix[i][n1]);
                }
            }
        }

        return nums;
    }
}
