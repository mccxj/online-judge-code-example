package sqrtx;

/**
 * Implement int sqrt(int x).
 * <p/>
 * Compute and return the square root of x.
 */
public class Solution {
    public int sqrt(int x) {
        int low = 0;

        int high = Math.min(46340, x / 2 + 1);
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (mid >= 46340) {
                return mid;
            }

            int s1 = mid * mid;
            int s2 = (mid + 1) * (mid + 1);
            if (s1 <= x && x < s2) {
                return mid;
            } else if (s2 <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}