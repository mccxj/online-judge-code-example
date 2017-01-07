package org.poj;

import java.util.Scanner;

/**
 * Yeehaa!(http://poj.org/problem?id=1799)
 * <p/>
 * <p/>
 * 数学题目,使用sin即可
 */
public class Main1799 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt();
        for (int i = 1; i <= m; i++) {
            double r = cin.nextDouble();
            int n = cin.nextInt();

            double k = Math.sin(Math.PI / n);
            System.out.println("Scenario #" + i + ":");
            System.out.printf("%.3f", r * k / (k + 1));
            System.out.println();
            System.out.println();
        }
    }
}