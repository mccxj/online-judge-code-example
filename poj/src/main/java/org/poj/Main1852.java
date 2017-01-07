package org.poj;

import java.util.Scanner;

/**
 * Ants(http://poj.org/problem?id=1852)
 * <p/>
 * <p/>
 * 蚂蚁爬行,需要点想象力,相碰调反方向相当于插身而过
 */
public class Main1852 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            int len = cin.nextInt();
            int min = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;

            int m = cin.nextInt();
            while (m-- > 0) {
                int t = cin.nextInt();
                if (len < 2 * t) {
                    t = len - t;
                }
                // 最少时间是所有蚂蚁都往最近端爬去
                if (t > min)
                    min = t;
                // 最长时间是所有蚂蚁都往最远端爬去
                if (len - t > max)
                    max = len - t;
            }

            System.out.println(min + " " + max);
        }
    }
}