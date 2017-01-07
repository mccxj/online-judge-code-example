package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Squares(http://poj.org/problem?id=2002)
 * <p/>
 * <p/>
 * 正方形判断,枚举所有点+排序后用于两分查找
 */
public class Main2002 {
    private static final long MAX = 20000L;
    private static final long PREFIX = 100000L;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;

        while ((n = cin.nextInt()) != 0) {
            // 用来保存所有坐标,保存方式为(x+20000)(y+20000)组成一个数
            long[] cods = new long[n];
            for (int i = 0; i < n; i++) {
                cods[i] = (cin.nextLong() + MAX) * PREFIX + (cin.nextLong() + MAX);
            }
            // 排序后用于两分查找使用
            Arrays.sort(cods);

            int sum = 0;// 保存正方形总数
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    // 遍历任意两点,查找它的顺时针或逆时针的正方形,判断另外两个点是否在坐标中存在
                    // 通过坐标变换就可以得出另外两个点的计算公式
                    long x1 = cods[i] / PREFIX - MAX;
                    long y1 = cods[i] % PREFIX - MAX;
                    long x2 = cods[j] / PREFIX - MAX;
                    long y2 = cods[j] % PREFIX - MAX;

                    // 判断顺时针的点
                    if (Arrays.binarySearch(cods, (y2 - y1 + x1 + MAX) * PREFIX + (x1 - x2 + y1 + MAX)) >= 0
                            && Arrays.binarySearch(cods, (y2 - y1 + x2 + MAX) * PREFIX + (x1 - x2 + y2 + MAX)) >= 0) {
                        sum++;
                    }
                    // 判断逆时针的点
                    if (Arrays.binarySearch(cods, (y1 - y2 + x1 + MAX) * PREFIX + (x2 - x1 + y1 + MAX)) >= 0
                            && Arrays.binarySearch(cods, (y1 - y2 + x2 + MAX) * PREFIX + (x2 - x1 + y2 + MAX)) >= 0) {
                        sum++;
                    }
                }
            }
            // 因为如果存在的话,必然会重复计算
            System.out.println(sum / 4);
        }
    }
}