package org.poj;

import java.util.Scanner;

/**
 * Hangover(http://poj.org/problem?id=1003)
 * 
 * <p>
 * Accepted 3140K 141MS Java 1174B 2013-04-06 22:26:21<br/>
 * 给出X,计算1/2 + 1/3 + 1/4 + ... + 1/(n + 1) >= X的最小的N值<br/>
 * 虽然直接累加进行比较即可,不过先计算好所有N的边界值,然后用两分查找
 */
public class Main1003 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        // 最大值为5.20,推算出来是276
        int max = 276;
        float[] sums = new float[max + 1];
        sums[0] = 0.00f;
        for (int i = 1; i <= max; i++) {
            sums[i] = sums[i - 1] + 1.0f / (i + 1);
        }

        float len;
        while ((len = cin.nextFloat()) != 0.00f) {
            // 进行两分查找
            int low = 1;
            int high = max;
            int mid;
            while (low <= high) {
                mid = (low + high) >>> 1;
                if (sums[mid] < len) {
                    low = mid + 1;
                } else if (sums[mid - 1] >= len) {
                    high = mid - 1;
                } else {
                    System.out.println(mid + " card(s)");
                    break;
                }
            }
        }
    }
}