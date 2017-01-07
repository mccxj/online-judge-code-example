package org.poj;

import java.util.Scanner;

/**
 * Binary Tree(http://poj.org/problem?id=2499)
 * <p/>
 * <p/>
 * 简单题,注意使用除法而不要用减法,不然TLE
 */
public class Main2499 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 1; i <= n; i++) {
            int left = 0;
            int right = 0;

            int x = cin.nextInt();
            int y = cin.nextInt();
            while (x != 1 || y != 1) {
                if (x < y) {
                    right += (y - 1) / x;
                    y = (y - 1) % x + 1;
                } else {
                    left += (x - 1) / y;
                    x = (x - 1) % y + 1;
                }
            }

            System.out.println("Scenario #" + i + ":");
            System.out.println(left + " " + right);
            System.out.println();
        }
    }
}