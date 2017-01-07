package org.poj;

import java.util.Scanner;

/**
 * How much did the businessman lose(http://poj.org/problem?id=2521)
 * <p/>
 * <p/>
 * 简单题目,不解释
 */
public class Main2521 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, m, p, c;
        while (true) {
            n = cin.nextInt();
            m = cin.nextInt();
            p = cin.nextInt();
            c = cin.nextInt();
            if (n == 0 && m == 0 && p == 0 && c == 0)
                break;
            System.out.println(n + p - m);
        }
    }
}