package org.poj;

import java.util.Scanner;

/**
 * Perfect Cubes(http://poj.org/problem?id=1543)
 * <p/>
 * <p/>
 * 数学题目,穷举,不过要估算一下范围
 */
public class Main1543 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        // a^3 = b^3 + c^3 + d^3 (
        for (int a = 6; a <= n; a++) {
            int a3 = a * a * a;
            int maxb = (int) Math.pow(a3 / 3.0, 1.0 / 3);
            int minc = (int) Math.pow(a3 / 2.0, 1.0 / 3);
            int maxd = (int) Math.pow(a3, 1.0 / 3);
            for (int b = 2; b <= maxb; b++) {
                for (int c = b + 1; c <= minc; c++) {
                    for (int d = maxb > c + 1 ? maxb : c + 1; d <= maxd; d++) {
                        if (a3 == b * b * b + c * c * c + d * d * d) {
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)", a, b, c, d);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}