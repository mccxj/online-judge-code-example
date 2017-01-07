package org.poj;

import java.util.Scanner;

/**
 * Perfection(http://poj.org/problem?id=1528)
 * <p/>
 * <p/>
 * 数学题目,枚举即可
 */
public class Main1528 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, sum;
        System.out.println("PERFECTION OUTPUT");
        while ((n = cin.nextInt()) != 0) {
            sum = 0;
            for (int i = 1; i <= n / 2; i++)
                if (n % i == 0)
                    sum += i;
            if (sum == n)
                System.out.printf("%5d  PERFECT", n);
            else if (sum < n)
                System.out.printf("%5d  DEFICIENT", n);
            else
                System.out.printf("%5d  ABUNDANT", n);

            System.out.println();
        }
        System.out.println("END OF OUTPUT");

    }
}