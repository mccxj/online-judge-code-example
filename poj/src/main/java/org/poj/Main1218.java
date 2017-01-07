package org.poj;

import java.util.Scanner;

/**
 * THE DRUNK JAILER(http://poj.org/problem?id=1218)
 * <p/>
 * <p/>
 * 数学题,其实就是找n以内的完全平方数的个数
 * 要让某个数N最终的状态是unlock,必须被整除偶数次(2k),即可分解成T^2k=N,所以N必须是完全平方数
 */
public class Main1218 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t;

        int n = cin.nextInt();
        while (n-- > 0) {
            t = cin.nextInt();
            System.out.println((int) Math.sqrt(t));
        }
    }
}