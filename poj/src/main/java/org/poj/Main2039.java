package org.poj;

import java.util.Scanner;

/**
 * To and Fro(http://poj.org/problem?id=2039)
 * <p/>
 * <p/>
 * 简单字符串操作题,使用二维数组存储
 */
public class Main2039 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, t;
        while ((n = Integer.parseInt(cin.nextLine())) != 0) {
            char[] s = cin.nextLine().toCharArray();
            int len = s.length;
            char[][] cs = new char[len / n][n];

            t = 0;//标识遍历的位置
            //遍历len/n行
            for (int i = 0; i < len / n; i++) {
                //每次遍历n个字符
                if (i % 2 == 0) {
                    for (int j = 0; j < n; j++)
                        cs[i][j] = s[t++];
                } else {
                    for (int j = n - 1; j >= 0; j--)
                        cs[i][j] = s[t++];
                }
            }

            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < n; i++)
                for (int j = 0; j < len / n; j++)
                    sb.append(cs[j][i]);
            System.out.println(sb);
        }
    }
}