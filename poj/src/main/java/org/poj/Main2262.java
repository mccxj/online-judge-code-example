package org.poj;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Goldbach's Conjecture(http://poj.org/problem?id=2262)
 * 
 * <p>
 * 验证1+1,使用筛选法得到所有的素数
 */
public class Main2262 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int max = 1000000;
        BitSet bs = new BitSet(max);
        bs.set(0);
        bs.set(1);

        for (int i = 2; i < max / 2; i++) {
            if (!bs.get(i)) {
                int t = i * 2;
                while (t < max) {
                    bs.set(t);
                    t += i;
                }
            }
        }

        int n;
        while ((n = cin.nextInt()) != 0) {
            for (int i = 3; i <= n / 2; i += 2) {
                if (!bs.get(i) && !bs.get(n - i)) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    break;
                }
            }
        }
    }
}