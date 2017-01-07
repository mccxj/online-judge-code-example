package org.poj;

import java.util.Scanner;

/**
 * Peter's smokes(http://poj.org/problem?id=2509)
 * <p/>
 * <p/>
 * 经典的智力题,不过没有考虑最后一换,不解释
 */
public class Main2509 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            long n = cin.nextLong();
            long k = cin.nextLong();
            if ((n * k) % (k - 1) == 0)
                System.out.println((n * k) / (k - 1) - 1);
            else
                System.out.println((n * k) / (k - 1));
        }
    }
}