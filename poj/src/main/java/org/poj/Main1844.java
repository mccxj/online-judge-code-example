package org.poj;

import java.util.Scanner;

/**
 * Sum(http://poj.org/problem?id=1844)
 * <p/>
 * <p/>
 * 找出和大于等于S的N,再累加看和与S的差为偶数的N即可
 */
public class Main1844 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int s = cin.nextInt();
        int n = (int) Math.sqrt(2 * s);
        if (n * (n + 1) < 2 * s)
            n++;

        int sum = n * (n + 1) / 2;
        while ((sum - s) % 2 != 0) {
            n++;
            sum += n;
        }
        System.out.println(n);
    }
}