package org.poj;

import java.util.Scanner;

/**
 * Unhappy Jinjin(http://poj.org/problem?id=2656)
 * <p/>
 * <p/>
 * 超级简单算术题,不解释
 */
public class Main2656 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, t, max, k;
        while ((n = cin.nextInt()) != 0) {
            max = 8;
            k = 0;
            for (int i = 1; i <= n; i++) {
                t = cin.nextInt() + cin.nextInt();
                if (t > max) {
                    max = t;
                    k = i;
                }
            }

            System.out.println(k);
        }
    }
}