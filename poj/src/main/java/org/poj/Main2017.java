package org.poj;

import java.util.Scanner;

/**
 * Speed Limit(http://poj.org/problem?id=2017)
 * <p/>
 * <p/>
 * 计算里程的简单数学题
 */
public class Main2017 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, s, t;
        while ((n = cin.nextInt()) != -1) {
            int dis = 0;
            int time = 0;
            while (n-- > 0) {
                s = cin.nextInt();
                t = cin.nextInt();
                dis += s * (t - time);
                time = t;
            }
            System.out.println(dis + " miles");
        }
    }
}