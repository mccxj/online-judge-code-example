package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Faulty Odometer(http://poj.org/problem?id=2719)
 * <p/>
 * <p/>
 * 对数字进行拆解,例如1399 = 1000 + 300 + 90 + 9,分别计算每部分跳过的数字
 */
public class Main2719 {
    // 预先计算各部分跳过的数字
    // 分别是0,10,100,1000,10000,100000,1000000,10000000,100000000
    // 计算过程见静态代码块
    private static final int[] M = {0, 1, 19, 271, 3439, 40951, 468559, 5217031, 56953279};
    // 用于大于4时的特殊处理
    private static final int[] N = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};

    /*
    static {
        M[0] = 0;
        int t = 1;
        for (int i = 1; i < 9; i++) {
            M[i] = M[i - 1] * 9 + t;
            t *= 10;
        }
    }
    */

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m, n, s, t, seq;

        while ((t = n = Integer.parseInt(reader.readLine())) != 0) {
            s = 0;//记录总的跳过数
            seq = 0;
            while (t != 0) {
                m = t % 10;
                if (m >= 5) {
                    // 大于4的话,要特殊处理
                    s += N[seq] + (m - 1) * M[seq];
                } else {
                    s += m * M[seq];
                }
                t /= 10;
                seq++;
            }
            System.out.println(n + ": " + (n - s));
        }
    }
}