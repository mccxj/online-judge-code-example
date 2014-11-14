package decodeWays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * <p/>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p/>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p/>
 * The number of ways decoding "12" is 2.
 */
public class Solution {
    public int numDecodings(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 0) {
            return 0;
        }

        int[] way = new int[len + 1];
        way[0] = 1;
        way[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= len; i++) {
            char c = s.charAt(i - 1);
            char p = s.charAt(i - 2);

            if ('1' == p) {
                if ('1' <= c && c <= '9') {
                    way[i] = way[i - 1] + way[i - 2];
                } else {
                    way[i] = way[i - 2];
                }
            } else if ('2' == p) {
                if ('1' <= c && c <= '6') {
                    way[i] = way[i - 1] + way[i - 2];
                } else if ('0' == c) {
                    way[i] = way[i - 2];
                } else {
                    way[i] = way[i - 1];
                }
            } else {
                if ('0' == c) {
                    way[i] = 0;
                } else {
                    way[i] = way[i - 1];
                }
            }
        }
        return way[len];
    }

    @Test
    public void test() {
        assertEquals(0, numDecodings("0"));
        assertEquals(1, numDecodings("2"));
        assertEquals(0, numDecodings("02"));
        assertEquals(2, numDecodings("12"));
        assertEquals(2, numDecodings("22"));
        assertEquals(1, numDecodings("32"));
        assertEquals(2, numDecodings("32012"));
    }
}
