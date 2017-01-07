package org.poj;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Factorial Frequencies(http://poj.org/problem?id=1454)
 * <p/>
 * <p/>
 * 高精度大整数运算
 */
public class Main1454 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = cin.nextInt()) != 0) {
            BigInteger bi = new BigInteger("1");
            for (int i = 2; i <= n; i++) {
                bi = bi.multiply(new BigInteger(String.valueOf(i)));
            }
            int[] num = new int[10];
            String s = bi.toString();
            for (int i = s.length() - 1; i >= 0; i--)
                num[s.charAt(i) - '0']++;

            System.out.println(n + "! --");
            System.out.printf("   (0)%5d    (1)%5d    (2)%5d    (3)%5d    (4)%5d", num[0], num[1], num[2], num[3], num[4]);
            System.out.println();
            System.out.printf("   (5)%5d    (6)%5d    (7)%5d    (8)%5d    (9)%5d", num[5], num[6], num[7], num[8], num[9]);
            System.out.println();
        }
    }
}