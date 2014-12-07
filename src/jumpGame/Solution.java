package jumpGame;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p/>
 * Each element in the array represents your maximum jump length at that position.
 * <p/>
 * Determine if you are able to reach the last index.
 * <p/>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p/>
 * A = [3,2,1,0,4], return false.
 */
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        int end = 0;
        for (int i = 0; i <= end && i < A.length; i++) {
            if (i + A[i] > end) {
                end = i + A[i];
            }
        }

        return end >= A.length - 1;
    }
}
