package org.poj;

import java.util.Scanner;

/**
 * Booklet Printing(http://poj.org/problem?id=1313)
 * <p/>
 * <p/>
 * 找规律数学题
 */
public class Main1313 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = cin.nextInt()) != 0) {
            System.out.println("Printing order for " + n + " pages:");
            int x = (n + 3) / 4;// 纸张数
            int y = n % 4;// 剩余数

            int start = 1;
            int end = n;
            if (y == 0) {
                for (int i = 1; i <= x; i++) {
                    System.out.printf("Sheet %d, front: %d, %d", i, end--, start++);
                    System.out.println();
                    System.out.printf("Sheet %d, back : %d, %d", i, start++, end--);
                    System.out.println();
                }
            } else if (y == 2) {
                System.out.printf("Sheet 1, front: Blank, %d", start++);
                System.out.println();
                System.out.printf("Sheet 1, back : %d, Blank", start++);
                System.out.println();
                for (int i = 2; i <= x; i++) {
                    System.out.printf("Sheet %d, front: %d, %d", i, end--, start++);
                    System.out.println();
                    System.out.printf("Sheet %d, back : %d, %d", i, start++, end--);
                    System.out.println();
                }
            } else if (y == 1) {
                System.out.printf("Sheet 1, front: Blank, %d", start++);
                System.out.println();
                if (n > 1) {
                    System.out.printf("Sheet 1, back : %d, Blank", start++);
                    System.out.println();
                    System.out.printf("Sheet 2, front: Blank, %d", start++);
                    System.out.println();
                    System.out.printf("Sheet 2, back : %d, %d", start++, end--);
                    System.out.println();
                }
                for (int i = 3; i <= x; i++) {
                    System.out.printf("Sheet %d, front: %d, %d", i, end--, start++);
                    System.out.println();
                    if (start < end) {
                        System.out.printf("Sheet %d, back : %d, %d", i, start++, end--);
                        System.out.println();
                    }
                }
            } else if (y == 3) {
                System.out.printf("Sheet 1, front: Blank, %d", start++);
                System.out.println();
                System.out.printf("Sheet 1, back : %d, %d", start++, end--);
                System.out.println();
                for (int i = 2; i <= x; i++) {
                    System.out.printf("Sheet %d, front: %d, %d", i, end--, start++);
                    System.out.println();
                    System.out.printf("Sheet %d, back : %d, %d", i, start++, end--);
                    System.out.println();
                }
            }
        }
    }
}