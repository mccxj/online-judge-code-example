package org.poj;

import java.util.Scanner;

/**
 * Palindrome(http://poj.org/problem?id=1159)
 * <p/>
 * <p/>
 * DP题,对字符反转，求两个字符串的最长公共子串
 * k[i][j]表示0~i,0~j个字符串的公共最长度
 * k[i][j] = max{k[i-1][j-1]+1,k[i-1][j],k[i][j-1]}
 * 需要使用滚动数组,不然会出现Memory Limit Exceeded
 */
public class Main1159 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());

        // 得到正向和反向的字符串
        String s1 = cin.nextLine();
        StringBuilder sb = new StringBuilder(n);
        for (int i = n - 1; i >= 0; i--)
            sb.append(s1.charAt(i));
        String s2 = sb.toString();

        // k[i][j]表示0~i,0~j个字符串的公共最长度,这里使用滚动数组
        int t = 0;
        int[][] k = new int[2][n + 1];
        for (int i = 1; i <= n; i++) {
            t = i & 1;
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    k[t][j] = k[t ^ 1][j - 1] + 1;
                else if (k[t][j - 1] > k[t ^ 1][j]) {
                    k[t][j] = k[t][j - 1];
                } else {
                    k[t][j] = k[t ^ 1][j];
                }
            }
        }

        System.out.println(n - k[t][n]);
    }
}