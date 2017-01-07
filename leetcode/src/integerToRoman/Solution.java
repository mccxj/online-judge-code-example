package integerToRoman;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given an integer, convert it to a roman numeral.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    private static String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public String intToRoman(int num) {
        int pos = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            if (num >= ints[pos]) {
                num -= ints[pos];
                sb.append(romans[pos]);
            } else {
                pos++;
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        assertEquals("IV", intToRoman(4));
        assertEquals("V", intToRoman(5));
        assertEquals("VII", intToRoman(7));
        assertEquals("CC", intToRoman(200));
        assertEquals("MDCCCLXXXIV", intToRoman(1884));
        assertEquals("MDCCCLXXXVIII", intToRoman(1888));
        assertEquals("MMMCMXCIX", intToRoman(3999));
    }
}
