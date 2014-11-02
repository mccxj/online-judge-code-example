package countAndSay;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        String num = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char prev = num.charAt(0);
            int sameLen = 1;
            for (int j = 1; j < num.length(); j++) {
                char curr = num.charAt(j);
                if (prev != curr) {
                    sb.append(sameLen).append(prev);
                    prev = curr;
                    sameLen = 1;
                } else {
                    sameLen++;
                }
            }
            sb.append(sameLen).append(prev);
            num = sb.toString();
        }
        return num;
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("1", s.countAndSay(1));
        assertEquals("11", s.countAndSay(2));
        assertEquals("21", s.countAndSay(3));
        assertEquals("1211", s.countAndSay(4));
        assertEquals("111221", s.countAndSay(5));
        assertEquals("312211", s.countAndSay(6));
    }
}