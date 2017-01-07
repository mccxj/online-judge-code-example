package org.poj;

/**
 * Self Numbers(http://poj.org/problem?id=1316)
 * <p/>
 * <p/>
 * 数学题,简单题,使用计数数组进行两遍查询即可
 */
public class Main1316 {
    public static void main(String args[]) {
        // 9999计算出来的是10035
        int[] gen = new int[10036];

        for (int i = 1; i < 10001; i++) {
            gen[d(i)]++;
        }

        for (int i = 1; i < 10001; i++) {
            if (gen[i] == 0)
                System.out.println(i);
        }
    }

    private static int d(int n) {
        int t = n;
        while (t != 0) {
            n += t % 10;
            t /= 10;
        }
        return n;
    }
}