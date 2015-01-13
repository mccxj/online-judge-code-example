package divideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * <p/>
 * If it is overflow, return MAX_INT.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        long dividendLong = (long) dividend;
        long divisorLong = (long) divisor;
        int sign = (dividendLong > 0 && divisorLong > 0) || (dividendLong < 0 && divisorLong < 0) ? 1
                : -1;

        dividendLong = Math.abs(dividendLong);
        divisorLong = Math.abs(divisorLong);
        if (dividendLong < divisorLong) {
            return 0;
        }

        long baseDiv = divisorLong;
        long base = 1;
        while ((baseDiv << 1) <= dividendLong) {
            baseDiv <<= 1;
            base <<= 1;
        }

        long value = 0;
        while (dividendLong > 0 && baseDiv >= divisorLong) {
            if (dividendLong >= baseDiv) {
                value += base;
                dividendLong -= baseDiv;
            }
            base >>= 1;
            baseDiv >>= 1;
        }

        if (sign > 0) {
            return (int) Math.min(value, Integer.MAX_VALUE);
        } else {
            return (int) -value;
        }
    }
}
