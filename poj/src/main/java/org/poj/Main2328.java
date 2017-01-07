package org.poj;

import java.util.Scanner;

/**
 * Guessing Game(http://poj.org/problem?id=2328)
 * <p/>
 * <p/>
 * 简单算术题,简单题
 */
public class Main2328 {
    public static void main(String args[]) {
        int n;
        String cmd;
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        Scanner cin = new Scanner(System.in);
        while ((n = Integer.parseInt(cin.nextLine())) != 0) {
            cmd = cin.nextLine();
            if ("right on".equals(cmd)) {
                if (low < n && n < high)
                    System.out.println("Stan may be honest");
                else
                    System.out.println("Stan is dishonest");

                low = Integer.MIN_VALUE;
                high = Integer.MAX_VALUE;
            } else if ("too high".equals(cmd)) {
                if (high > n)
                    high = n;
            } else if ("too low".equals(cmd)) {
                if (low < n)
                    low = n;
            }
        }
    }
}