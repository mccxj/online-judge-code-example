package org.poj;

import java.util.Scanner;

/**
 * Just the Facts(http://poj.org/problem?id=1604)
 * <p/>
 * <p/>
 * 数学题,找到N!最后一位非0的数,必须保留5位尾数才足够计算
 */
public class Main1604 {
    public static void main(String args[]) {
        int[] f = new int[10001];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < 10001; i++) {
            int t = f[i - 1] * i;
            while (t % 10 == 0)
                t /= 10;
            f[i] = t % 100000;
        }

        for (int i = 2; i < 10001; i++) {
            while (f[i] % 10 == 0)
                f[i] /= 10;
            f[i] %= 10;
        }


        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int n = cin.nextInt();
            System.out.printf("%5d -> %d", n, f[n]);
            System.out.println();
        }
    }
}