package org.poj;

import java.util.Scanner;

/**
 * Beat the Spread!(http://poj.org/problem?id=2301)
 * 
 * <p>
 * A+B,给出两个数的和、差,判断这两个数是否存在
 */
public class Main2301 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            int a = cin.nextInt();
            int b = cin.nextInt();

            int ta = (a + b) / 2;
            int tb = (a - b) / 2;
            if (ta >= 0 && tb >= 0 && ta + tb == a && ta - tb == b)
                System.out.println(ta + " " + tb);
            else
                System.out.println("impossible");
        }
    }
}