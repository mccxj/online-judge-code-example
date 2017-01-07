package org.poj;

import java.util.Scanner;

/**
 * Integer Approximation(http://poj.org/problem?id=1650)
 * <p/>
 * <p/>
 * 高精度数学题
 */
public class Main1650 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        double a = cin.nextDouble();//A (0.1 <= A < 10)
        int l = cin.nextInt();//L (1 <= L <= 100000)

        double min = Double.MAX_VALUE;
        // 让|A - N / D|最小,(1 <= N, D <= L)
        int minn = -1;
        int mind = -1;

        for (int d = 1; d <= l; d++) {
            int maxn = (int) (a * d);
            for (int n = maxn - 10; n <= maxn + 10 && n <= l; n++) {
                double t = Math.abs(a - n * 1.0 / d);
                if (t < min) {
                    min = t;
                    minn = n;
                    mind = d;
                }
            }
        }
        System.out.println(minn + " " + mind);
    }
}