package org.poj;

import java.util.Scanner;

/**
 * Balance(http://poj.org/problem?id=1837)
 * <p/>
 * <p/>
 * 平衡砝码,0/1背包问题变种
 */
public class Main1837 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int cs = cin.nextInt();
        int gs = cin.nextInt();
        int[] c = new int[cs];
        int[] g = new int[gs];

        for (int i = 0; i < cs; i++)
            c[i] = cin.nextInt();

        int sum = 0;
        for (int i = 0; i < gs; i++) {
            g[i] = cin.nextInt();
            sum += g[i];
        }

        int add = -c[0] * sum;// 为了避免索引值为负数,设置的偏移值
        int max = c[cs - 1] * sum + add + 1;
        // v[i][j]表示挂上0~i个砝码,得到总总量为j的情况数量
        int[][] v = new int[gs][max];

        // 初始化第0个砝码的情况
        for (int k = 0; k < cs; k++) {
            v[0][c[k] * g[0] + add] = 1;
        }

        for (int i = 1; i < gs; i++) {
            for (int j = 0; j < max; j++) {
                for (int k = 0; k < cs; k++) {
                    int tmp = j - c[k] * g[i];
                    if (tmp >= 0 && tmp < max) {
                        v[i][j] += v[i - 1][tmp];
                    }
                }
            }
        }
        System.out.println(v[gs - 1][add]);
    }
}