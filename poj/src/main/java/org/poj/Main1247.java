package org.poj;

import java.util.Scanner;

/**
 * Magnificent Meatballs(http://poj.org/problem?id=1247)
 * <p/>
 * <p/>
 * 简单题,找到左边和相等的点
 */
public class Main1247 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, sum, i, left, right;
        boolean ok;
        while ((n = cin.nextInt()) != 0) {
            int[] guest = new int[n];
            sum = 0;
            for (i = 0; i < n; i++) {
                guest[i] = cin.nextInt();
                sum += guest[i];
            }

            ok = false;
            if (sum % 2 == 0) {
                left = 0;
                right = sum;
                i = 0;
                while (left < right && i < n) {
                    left += guest[i];
                    right -= guest[i];
                    i++;
                }

                if (left == right)
                    ok = true;
            }

            if (ok)
                System.out.println("Sam stops at position " + i + " and Ella stops at position " + (i + 1) + ".");
            else
                System.out.println("No equal partitioning.");
        }
    }
}