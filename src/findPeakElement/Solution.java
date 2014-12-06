package findPeakElement;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A peak element is an element that is greater than its neighbors.
 * <p/>
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * <p/>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p/>
 * You may imagine that num[-1] = num[n] = -∞.
 * <p/>
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * <p/>
 * click to show spoilers.
 * <p/>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution {
    public int findPeakElement(int[] num) {
        int low = 0;
        int high = num.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (mid > low) {
                if (num[mid] > num[mid - 1]) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            } else {
                if (num[mid] > num[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return low;
    }

    @Test
    public void test() {
        assertEquals(2, findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
