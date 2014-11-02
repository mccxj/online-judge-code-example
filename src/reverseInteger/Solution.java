package reverseInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * click to show spoilers.
 * <p/>
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * <p/>
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * <p/>
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * <p/>
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 */
public class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE){
            throw new RuntimeException();
        }
        
        boolean nav = false;
        if (x < 0) {
            nav = true;
            x = -x;
        }

        int t = 0;
        while (x != 0) {
            t = 10 * t + x % 10;
            x = x / 10;
        }
        if(t<0) {
            throw new RuntimeException();
        }
        
        if (nav) {
            t = -t;
        }
        return t;
    }

    @Test(expected = Exception.class)
    public void test() {
        Solution s = new Solution();
        assertEquals(321, s.reverse(123));
        assertEquals(-321, s.reverse(-123));
        assertEquals(0, s.reverse(0));
        assertEquals(1, s.reverse(10));
        assertEquals(1, s.reverse(100));
        System.out.println(s.reverse(1000000003));
    }
}
