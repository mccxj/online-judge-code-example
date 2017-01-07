package org.poj;

import java.util.Scanner;

/**
 * Uniform Generator(http://poj.org/problem?id=1597)
 * <p/>
 * <p/>
 * 数学题目,随机数模拟
 */
public class Main1597 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int step = cin.nextInt();
            int mod = cin.nextInt();

            boolean ok = true;
            int t = step % mod;
            if (t == 0 || gcd(mod, t) != 1) {
                ok = false;
            } else {
                // seed(x+1) = [ seed(x) + STEP ] % MOD
                boolean[] seed = new boolean[mod];
                seed[0] = true;
                int tmp = 0;

                for (int i = 1; i < mod; i++) {
                    tmp = (tmp + t) % mod;
                    if (seed[tmp]) {
                        ok = false;
                        break;
                    }
                    seed[tmp] = true;
                }
            }

            String choice = ok ? "Good Choice" : "Bad Choice";
            System.out.printf("%10d%10d    %s", step, mod, choice);
            System.out.println();
            System.out.println();
        }
    }

    private static int gcd(int a, int b) {
        int t;
        while (a % b != 0) {
            t = a % b;
            a = b;
            b = t;
        }
        return b;
    }
}