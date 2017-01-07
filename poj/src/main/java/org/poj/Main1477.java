package org.poj;

import java.util.Scanner;

/**
 * Box of Bricks(http://poj.org/problem?id=1477)
 * <p/>
 * <p/>
 * 移动箱子,简单题目
 */
public class Main1477 {
    private static final int MAX = 50;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        int seq = 1;
        int[] num = new int[MAX];
        while ((n = cin.nextInt()) != 0) {
            int total = 0;
            for (int i = 0; i < n; i++) {
                num[i] = cin.nextShort();
                total += num[i];
            }

            int avg = total / n;
            int move = 0;
            for (int i = 0; i < n; i++) {
                if (num[i] > avg) {
                    move += num[i] - avg;
                }

            }
            System.out.println("Set #" + seq);
            System.out.printf("The minimum number of moves is %d.", move);
            System.out.println();
            System.out.println();
            seq++;
        }
    }
}