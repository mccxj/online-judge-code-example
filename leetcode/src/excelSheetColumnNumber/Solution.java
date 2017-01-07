package excelSheetColumnNumber;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Related to question Excel Sheet Column Title
 * <p/>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p/>
 * For example:
 * <p/>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            n = n * 26 + (c - 'A' + 1);
        }
        return n;
    }

    @Test
    public void test() {
        assertEquals(2, titleToNumber("B"));
        assertEquals(26, titleToNumber("Z"));
        assertEquals(27, titleToNumber("AA"));
        assertEquals(28, titleToNumber("AB"));
        assertEquals(29, titleToNumber("AC"));
        assertEquals(53, titleToNumber("BA"));
    }
}
