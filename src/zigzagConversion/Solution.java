package zigzagConversion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || nRows <= 1 || nRows >= s.length()) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[nRows];
        for (int i = 0; i < nRows; i++) {
            sbs[i] = new StringBuilder();
        }

        int step = nRows + nRows - 2;
        for (int i = 0; i < s.length(); i++) {
            if (i % step < nRows) {
                sbs[i % step].append(s.charAt(i));
            } else {
                sbs[step - i % step].append(s.charAt(i));
            }
        }

        StringBuilder cov = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            cov.append(sbs[i].toString());
        }
        return cov.toString();
    }

    @Test
    public void test() {
        assertEquals("PAYPALISHIRING", convert("PAYPALISHIRING", 1));
        assertEquals("PYAIHRNAPLSIIG", convert("PAYPALISHIRING", 2));
        assertEquals("PAHNAPLSIIGYIR", convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", convert("PAYPALISHIRING", 4));
        assertEquals("PAYPALISHIRIGN", convert("PAYPALISHIRING", 13));
        assertEquals("PAYPALISHIRING", convert("PAYPALISHIRING", 14));
    }
}

