package org.poj;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Round and Round We Go(http://poj.org/problem?id=1047)
 * <p/>
 * <p/>
 * 高精度模拟题
 */
public class Main1047 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int u, v;
        while (cin.hasNext()) {
            String s = cin.next();
            int len = s.length();
            char[] cs = s.toCharArray();
            Arrays.sort(cs);

            boolean ok = true;
            BigInteger origin = new BigInteger(s, 10);
            for (int i = 2; i <= len; i++) {
                origin = origin.add(new BigInteger(s, 10));
                char[] css = origin.toString().toCharArray();
                Arrays.sort(css);

                // 超长肯定不行
                if (css.length > len) {
                    ok = false;
                    break;
                }

                // 从尾巴开始比较
                for (u = len - 1, v = css.length - 1; u >= 0 && v >= 0; u--, v--) {
                    if (cs[u] != css[v]) {
                        ok = false;
                        break;
                    }
                }

                if (!ok)
                    break;

                // 如果还有剩下的,那么都应该是0
                while (u >= 0) {
                    if (cs[u--] != '0') {
                        ok = false;
                        break;
                    }
                }
            }

            if (ok)
                System.out.println(s + " is cyclic");
            else
                System.out.println(s + " is not cyclic");
        }
    }
}