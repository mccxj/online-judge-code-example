package org.poj;

import java.util.Scanner;

/**
 * Primary Arithmetic(http://poj.org/problem?id=2562)
 * <p/>
 * <p/>
 * 高精度,模拟加法进位
 */
public class Main2562 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long a, b;
        while (true) {
            a = cin.nextLong();
            b = cin.nextLong();
            if (a == 0 && b == 0)
                break;

            int carry = 0;
            int f = 0;
            while (a != 0 || b != 0) {
                if (a % 10 + b % 10 + f >= 10) {
                    f = 1;
                    carry++;
                } else
                    f = 0;
                a /= 10;
                b /= 10;
            }

            if (carry == 0)
                System.out.println("No carry operation.");
            else if (carry == 1)
                System.out.println("1 carry operation.");
            else
                System.out.println(carry + " carry operations.");
        }
    }
}