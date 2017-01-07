package org.poj;

import java.util.Scanner;

/**
 * The 3n + 1 problem(http://poj.org/problem?id=1207)
 * <p/>
 * <p/>
 * 数学题,直接模拟,使用记忆化搜索,并对某些值太大的只能特殊处理
 */
public class Main1207 {
    private static final int MAX = 10000;
    private static int[] cyc = new int[MAX];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        cyc[1] = 1;
        for (int i = 2; i < 10000; i++) {
            calcyc(i);
        }

        while (cin.hasNext()) {
            int i = cin.nextInt();
            int j = cin.nextInt();

            int min = i;
            int max = j;
            // 注意输入的大小顺序和输出要原顺序
            if (min > max) {
                int tmp = min;
                min = max;
                max = tmp;
            }
            int sum = cyc[i];
            for (int t = min + 1; t <= max; t++)
                if (cyc[t] > sum)
                    sum = cyc[t];
            System.out.printf("%d %d %d", i, j, sum);
            System.out.println();
        }
    }

    public static void calcyc(int t) {
        if (cyc[t] == 0) {
            if (t % 2 == 0) {
                calcyc(t / 2);
                cyc[t] = cyc[t / 2] + 1;
            } else {
                int k = 3 * t + 1;
                // 避免值太大
                if (k >= 10000) {
                    int sum = 0;
                    while (k != 1) {
                        if (k % 2 == 0) {
                            sum++;
                            k /= 2;
                        } else {
                            sum++;
                            k = 3 * k + 1;
                        }
                        if (k < 10000) {
                            calcyc(k);
                            sum += cyc[k] - 1;
                            break;
                        }
                    }
                    cyc[t] = sum + 2;
                } else {
                    calcyc(k);
                    cyc[t] = cyc[k] + 1;
                }
            }
        }
    }
}