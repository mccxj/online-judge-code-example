package maximumProductSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p/>
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Solution {
    public int maxProduct(int[] A) {
        int[] max = new int[A.length];

        max[0] = A[0];// max product ends with pos i.
        int navPos = A[0] < 0 ? 0 : -1;
        int navTotal = A[0] < 0 ? 1 : 0;
        int maxProdcut = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] == 0) {
                navPos = -1;
                navTotal = 0;
            } else if (max[i - 1] == 0) {
                max[i] = A[i];
            } else if (max[i - 1] > 0 && A[i] > 0) {
                max[i] = max[i - 1] * A[i];
            } else if (max[i - 1] < 0 && A[i] < 0) {
                max[i] = max[i - 1] * A[i];
                if (navPos - 1 >= 0 && max[navPos - 1] > 0) {
                    max[i] = max[i] * max[navPos - 1];
                }
            } else if (max[i - 1] < 0 && A[i] > 0) {
                max[i] = A[i];
            } else if (max[i - 1] > 0 && A[i] < 0) {
                if (navPos == -1) {
                    max[i] = A[i];
                } else if (navTotal % 2 == 0) {
                    max[i] = max[i - 1] * A[i] / A[navPos];
                    if (navPos - 1 >= 0 && max[navPos - 1] > 0) {
                        max[i] = max[i] / max[navPos - 1];
                    }
                } else {
                    max[i] = max[i - 1] * A[i] * A[navPos];
                    if (navPos - 1 >= 0 && max[navPos - 1] > 0) {
                        max[i] = max[i] * max[navPos - 1];
                    }
                }
            }

            if (A[i] < 0) {
                if (navPos == -1) {
                    navPos = i;
                }
                navTotal++;
            }
            if (max[i] > maxProdcut) {
                maxProdcut = max[i];
            }
        }

        return maxProdcut;
    }
}
