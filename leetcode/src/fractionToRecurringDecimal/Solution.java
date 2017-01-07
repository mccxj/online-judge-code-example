package fractionToRecurringDecimal;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * <p/>
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * <p/>
 * For example,
 * <p/>
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Credits:
 * Special thanks to @Shangrila for adding this problem and creating all test cases.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        java.math.BigInteger num = java.math.BigInteger.valueOf(numerator);
        java.math.BigInteger deno = java.math.BigInteger.valueOf(denominator);
        boolean nav = false;

        if (num.compareTo(java.math.BigInteger.ZERO) < 0) {
            num = num.negate();
            nav = !nav;
        }
        if (deno.compareTo(java.math.BigInteger.ZERO) < 0) {
            deno = deno.negate();
            nav = !nav;
        }

        StringBuilder sb = new StringBuilder();
        if (num.compareTo(deno) > 0) {
            sb.append(num.divide(deno));
            num = num.mod(deno);
        } else {
            sb.append('0');
        }

        if (num.compareTo(java.math.BigInteger.ZERO) != 0) {
            sb.append('.');
        }

        Map<BigInteger, Integer> nums = new HashMap<BigInteger, Integer>();
        int pos = sb.length();
        while (num.compareTo(java.math.BigInteger.ZERO) != 0) {
            nums.put(num, pos++);
            num = num.multiply(java.math.BigInteger.TEN);
            sb.append(num.divide(deno));
            num = num.mod(deno);

            if (nums.containsKey(num)) {
                int oldPos = nums.get(num);
                sb.insert(oldPos, '(');
                sb.append(')');
                break;
            }
        }

        if (nav && !sb.toString().equals("0")) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}