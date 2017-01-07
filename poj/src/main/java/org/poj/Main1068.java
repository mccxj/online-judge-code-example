package org.poj;

import java.util.Scanner;

/**
 * Parencodings(http://poj.org/problem?id=1068)
 * <p/>
 * <p/>
 * 简单的数学题,不解释
 */
public class Main1068 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            int m = cin.nextInt();
            int[] ps = new int[m];
            for (int i = 0; i < m; i++)
                ps[i] = cin.nextInt();
            for (int i = m - 1; i >= 1; i--)
                ps[i] = ps[i] - ps[i - 1];

            System.out.print(1);
            ps[0]--;

            for (int i = 1; i < m; i++) {
                for (int j = i; j >= 0; j--) {
                    if (ps[j] > 0) {
                        ps[j]--;
                        System.out.printf(" %d", i - j + 1);
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}