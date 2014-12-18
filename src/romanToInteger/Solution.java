package romanToInteger;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    private static Map<Character, Integer> romans = new HashMap<Character, Integer>();

    static {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }

    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = romans.get(s.charAt(i));
            if (i < s.length() - 1 && n < romans.get(s.charAt(i + 1))) {
                sum -= n;
            } else {
                sum += n;
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(4, romanToInt("IV"));
        assertEquals(5, romanToInt("V"));
        assertEquals(7, romanToInt("VII"));
        assertEquals(200, romanToInt("CC"));
        assertEquals(1884, romanToInt("MDCCCLXXXIV"));
        assertEquals(1888, romanToInt("MDCCCLXXXVIII"));
        assertEquals(3999, romanToInt("MMMCMXCIX"));
    }
}
