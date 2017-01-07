package org.poj;

import java.util.Scanner;

/**
 * Keep on Truckin'(http://poj.org/problem?id=2578)
 * <p/>
 * <p/>
 * 超级简单题
 */
public class Main2578 {
    public static void main(String args[]) {
        int wheeler18 = 168;

        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            int n = cin.nextInt();
            if (n <= wheeler18) {
                System.out.println("CRASH " + n);
                return;
            }
        }
        System.out.println("NO CRASH");
    }
}