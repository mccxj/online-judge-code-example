package firstMissingPositive;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p/>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p/>
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            int t = A[j - 1];
            A[j - 1] = 0;
            while (t >= 1 && t <= A.length && A[t - 1] != t) {
                j = A[t - 1];
                A[t - 1] = t;
                t = j;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
