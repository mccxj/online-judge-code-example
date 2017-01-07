package org.poj;

import java.util.Scanner;

/**
 * Hamming Problem(http://poj.org/problem?id=2545)
 * <p/>
 * <p/>
 * 数学题,和2591是类似的,需要用到long
 */
public class Main2545 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        long[] p = new long[3];// 保存每次递增的数
        int[] k = new int[3];// 保存当前计数
        long[] m = new long[1000000];// 保存当前值
        p[0] = cin.nextLong();
        p[1] = cin.nextLong();
        p[2] = cin.nextLong();
        m[0] = 1;

        int n = cin.nextInt();
        long min;
        for (int t = 1; t <= n; t++) {
            min = m[k[0]] * p[0];
            for (int i = 1; i < 3; i++)
                if (m[k[i]] * p[i] < min)
                    min = m[k[i]] * p[i];
            m[t] = min;
            for (int i = 0; i < 3; i++)
                if (m[k[i]] * p[i] == min) {
                    k[i]++;
                }
        }

        System.out.println(m[n]);
    }
}