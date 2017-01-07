package org.poj;

import java.util.Scanner;

/**
 * No Brainer(http://poj.org/problem?id=2027)
 * <p/>
 * <p/>
 * 超级A+B题,娱乐性质
 */
public class Main2027 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            if (cin.nextInt() >= cin.nextInt())
                System.out.println("MMM BRAINS");
            else
                System.out.println("NO BRAINS");
        }
    }
}