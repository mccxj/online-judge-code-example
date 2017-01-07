package org.poj;

import java.util.Scanner;

/**
 * Doubles(http://poj.org/problem?id=1552)
 * <p/>
 * <p/>
 * 数学题,简单题,使用计数数组即可
 */
public class Main1552 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int n;
        while ((n = cin.nextInt()) != -1) {
            boolean[] s = new boolean[100];

            s[n] = true;
            while ((n = cin.nextInt()) != 0) {
                s[n] = true;
            }
            int total = 0;
            // 超过49的的数都不可能找到双倍的数
            for (int i = 1; i < 50; i++) {
                if (s[i] && s[i * 2])
                    total++;
            }
            System.out.println(total);
        }
    }
}