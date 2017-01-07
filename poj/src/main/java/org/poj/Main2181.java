package org.poj;

import java.util.Scanner;

/**
 * 动态规划题目
 */
public class Main2181 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] potion = new int[n + 1];
        for (int i = 1; i <= n; i++)
            potion[i] = cin.nextInt();

        int[] ja = new int[n + 1];// 表示前i个为奇数时的最大跳跃高度
        int[] jb = new int[n + 1];// 表示前i个为偶数时的最大跳跃高度

        for (int i = 1; i <= n; i++) {
            ja[i] = Math.max(ja[i - 1], jb[i - 1] + potion[i]);
            jb[i] = Math.max(jb[i - 1], ja[i - 1] - potion[i]);
        }

        System.out.println(Math.max(ja[n], jb[n]));
    }
}