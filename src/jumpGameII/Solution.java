package jumpGameII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p/>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] jumps = new int[A.length];
        jumps[0] = 0;

        int end = 0;
        for (int i = 0; i <= end && i < A.length; i++) {
            if (i + A[i] > end) {
                for (int j = end + 1; j <= i + A[i] && j < A.length; j++) {
                    jumps[j] = jumps[i] + 1;
                }
                end = i + A[i];
            }
        }

        return jumps[A.length - 1];
    }

    @Test
    public void test() {
        assertEquals(2, jump(new int[]{2, 3, 1, 1, 4}));
    }
}
