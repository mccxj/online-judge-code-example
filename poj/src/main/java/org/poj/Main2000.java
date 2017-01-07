package org.poj;

import java.util.Scanner;

/**
 * Gold Coins(http://poj.org/problem?id=2000)
 * <p/>
 * <p/>
 * 公式题,找规律
 */
public class Main2000 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = cin.nextInt()) != 0) {
            // 利用公式求出和最接近n的k值
            int k = (int) (Math.sqrt(8 * n + 1) - 1) / 2;
            // 利用平方和公式1^2+2^2+3^2+…+n^2=n(n+1)(2n+1)/6
            int sum = k * (k + 1) * (2 * k + 1) / 6;
            // 剩余部分
            int r = (k + 1) * (n - k * (k + 1) / 2);
            System.out.println(n + " " + (sum + r));
        }
    }
}