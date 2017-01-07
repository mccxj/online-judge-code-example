package org.poj;

import java.util.Scanner;

/**
 * Basically Speaking(http://poj.org/problem?id=1546)
 * <p/>
 * <p/>
 * 进制转换题目
 */
public class Main1546 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String s = cin.next();
            int radix1 = cin.nextInt();
            int radix2 = cin.nextInt();

            int n = Integer.parseInt(s, radix1);
            s = Integer.toString(n, radix2).toUpperCase();
            if (s.length() > 7)
                s = "ERROR";
            System.out.printf("%7s", s);
            System.out.println();
        }
    }
}