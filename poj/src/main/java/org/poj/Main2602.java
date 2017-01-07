package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Superlong sums(http://poj.org/problem?id=2602)
 *
 * <p/>
 * 大整数相加,每位相加即可,用字符来操作不用int.输入也很重要,换成字符串再输出,不然也是TLE
 */
public class Main2602 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] a = new char[n];
        char[] b = new char[n];
        for (int i = 0; i < n; i++) {
            String t = br.readLine();
            a[i] = t.charAt(0);
            b[i] = t.charAt(2);
        }

        int f = 0;// 表示进位
        for (int i = n - 1; i >= 0; i--) {
            int s = (a[i] - '0') + (b[i] - '0') + f;
            if (s >= 10) {
                a[i] = (char) ('0' + (s - 10));
                f = 1;
            } else {
                a[i] = (char) ('0' + s);
                f = 0;
            }
        }

        if (f == 1)
            System.out.print('1');
        System.out.println(new String(a));
    }
}