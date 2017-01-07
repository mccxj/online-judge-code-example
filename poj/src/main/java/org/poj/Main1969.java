package org.poj;

import java.util.Scanner;

/**
 * Count on Canton(http://poj.org/problem?id=1969)
 * <p/>
 * <p/>
 * 找规律公式题,找出哪一斜排,找到哪个位置即可
 */
public class Main1969 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while (cin.hasNext()) {
            n = cin.nextInt();
            // 利用公式求出是在哪一斜排
            int k = (int) (Math.sqrt(8 * n + 1) - 1) / 2;
            // 剩余部分
            int r = n - k * (k + 1) / 2;
            // 根据是当前排还是下一排调整k和r
            if (r != 0) {
                k++;
            } else {
                r = k;
            }

            // 分子分母和是k+1,k是偶数 斜向下,否则斜向上
            if (k % 2 == 0) {
                System.out.printf("TERM %d IS %d/%d", n, r, k + 1 - r);
            } else {
                System.out.printf("TERM %d IS %d/%d", n, k + 1 - r, r);
            }
            System.out.println();
        }
    }
}