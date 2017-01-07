package org.poj;

import java.util.Scanner;

/**
 * Digital Roots(http://poj.org/problem?id=1519)
 * <p/>
 * <p/>
 * 高精度,按位累加,第一次需要用字符逐个统计,接下来就不需要了
 */
public class Main1519 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long n, k;
        String s;
        while (!(s = cin.nextLine()).equals("0")) {
            n = 0;
            for (int i = 0; i < s.length(); i++)
                n += s.charAt(i) - '0';

            while (n >= 10) {
                k = 0;
                while (n != 0) {
                    k += n % 10;
                    n /= 10;
                }
                n = k;
            }
            System.out.println(n);
        }
    }
}