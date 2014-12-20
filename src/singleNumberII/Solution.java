package singleNumberII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution {
    public int singleNumber(int[] A) {
        int[] key = new int[32];//int has 32bits
        for (int e : A) {
            int i = 0;
            while (i < 32) {
                if ((e & (1 << i)) != 0) {
                    key[i]++;
                }
                i++;
            }
        }

        int n = 0;
        for (int i = 0; i < 32; i++) {
            n += key[i] % 3 * (1 << i);
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(500, singleNumber(new int[]{
                1, 2, 3, 4, 3, 3, 500, 1, 2, 1, 2, 4, 4
        }));
    }
}
