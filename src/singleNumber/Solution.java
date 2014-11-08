package singleNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
    public int singleNumber(int[] A) {
        int n = 0;
        for (int e : A) {
            n ^= e;
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(2, singleNumber(new int[]{1, 2, 3, 1, 3}));
        assertEquals(1, singleNumber(new int[]{1, 3, 21, 21, 3}));
        assertEquals(-2, singleNumber(new int[]{1, 0, -1, 21, 21, -1, -2, 0, 1}));
    }
}
