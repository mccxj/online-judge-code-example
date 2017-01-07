package maximumSubarray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * <p/>
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * <p/>
 * click to show more practice.
 * <p/>
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] max = new int[A.length];
        max[0] = A[0];
        int m = max[0];
        for (int i = 1; i < A.length; i++) {
            if (max[i - 1] >= 0) {
                max[i] = max[i - 1] + A[i];
            } else {
                max[i] = A[i];
            }
            if (max[i] > m) {
                m = max[i];
            }
        }
        return m;
    }

    @Test
    public void test() {
        assertEquals(6, maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(-2, maxSubArray(new int[]{-2}));
        assertEquals(20, maxSubArray(new int[]{-2, 0, 20, -19, 10}));
    }
}
