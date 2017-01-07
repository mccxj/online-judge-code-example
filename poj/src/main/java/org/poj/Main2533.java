package org.poj;

import java.util.Scanner;

/**
 * Longest Ordered Subsequence(http://poj.org/problem?id=2533)
 * <p/>
 * <p/>
 * 经典的DP,最长递升子序列,设sub[i]为以i结束的最长子序列的长度
 */
public class Main2533 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] m = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            m[i] = cin.nextInt();
        }

        int[] sub = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (m[i] > m[j] && sub[j] > max)
                    max = sub[j];
            }
            sub[i] = max + 1;
        }

        int max = sub[1];
        for (int i = 2; i <= n; i++)
            if (sub[i] > max)
                max = sub[i];
        System.out.println(max);
    }
}