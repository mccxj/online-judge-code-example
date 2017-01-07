package org.poj;

import java.util.Scanner;

/**
 * Above Average(http://poj.org/problem?id=2350)
 * <p/>
 * <p/>
 * 简单数学题,注意精度
 */
public class Main2350 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            int sum = 0;
            int m = cin.nextInt();
            int[] ms = new int[m];
            for (int i = 0; i < m; i++) {
                ms[i] = cin.nextInt();
                sum += ms[i];
            }

            int pass = 0;
            for (int i = 0; i < m; i++) {
                if (ms[i] * m > sum)
                    pass++;
            }

            System.out.printf("%.3f", pass * 100.0 / m);
            System.out.println("%");
        }
    }
}