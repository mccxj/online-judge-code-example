package grayCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p/>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * <p/>
 * 这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
 * 1位格雷码有两个码字
 * (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
 * (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Arrays.asList(0);
        }

        List<Integer> keys = Arrays.asList(0, 1);
        int step = 2;
        for (int i = 1; i < n; i++) {
            List<Integer> tmps = new ArrayList<Integer>();
            for (int j = 0; j < keys.size(); j++) {
                tmps.add(keys.get(j));
            }
            for (int j = keys.size() - 1; j >= 0; j--) {
                tmps.add(step + keys.get(j));
            }
            keys = tmps;
            step *= 2;
        }
        return keys;
    }
}
