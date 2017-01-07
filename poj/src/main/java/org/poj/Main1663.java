package org.poj;

import java.util.Scanner;

/**
 * Number Steps(http://poj.org/problem?id=1663)
 * <p/>
 * <p/>
 * 简单题目,不解释,也不打算简化公式了
 */
public class Main1663 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        while (n-- > 0) {
            int x = cin.nextInt();
            int y = cin.nextInt();

            // 0~1,4~5,8~9...
            if (x == y) {
                if (x % 2 == 0)
                    System.out.println(2 * x);
                else
                    System.out.println(2 * x - 1);
            }
            // 2~3,6~7,10~11...
            else if (y + 2 == x) {
                if (x % 2 == 0)
                    System.out.println(2 * x - 2);
                else
                    System.out.println(2 * x - 3);
            } else {
                System.out.println("No Number");
            }

        }
    }
}