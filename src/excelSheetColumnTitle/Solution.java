package excelSheetColumnTitle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p/>
 * For example:
 * <p/>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Credits:
 * Special thanks to @ifanchu for adding this problem and creating all test cases.
 */
public class Solution {
    private static final String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        do {
            int last = (n - 1) % 26 + 1;
            sb.insert(0, key.charAt(last - 1));
            n = (n - last) / 26;
        } while (n != 0);
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("B", convertToTitle(2));
        assertEquals("Z", convertToTitle(26));
        assertEquals("AA", convertToTitle(27));
        assertEquals("AB", convertToTitle(28));
        assertEquals("AC", convertToTitle(29));
        assertEquals("BA", convertToTitle(53));
    }
}
