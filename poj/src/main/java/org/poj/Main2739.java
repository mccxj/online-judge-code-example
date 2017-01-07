package org.poj;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Sum of Consecutive Prime Numbers(http://poj.org/problem?id=2739)
 * 
 * <p>
 * 判断某个数可以表示成连续素数和的总数,先计算所有的素数<br/>
 * 再计算出前N项的和,两个和的差就是连续素数的和了.不过我是直接搜索的
 */
public class Main2739 {
    private static final int MAX = 1230;// 10000以下总共有1229个素数
    private static final int N = 10000;

    public static void main(String args[]) {
        int c = 0;
        int[] prime = new int[MAX];
        BitSet bs = new BitSet(N);

        // 筛选法计算所有的素数
        for (int i = 2; i < N; i++) {
            if (!bs.get(i)) {
                prime[c++] = i;

                int k = i * 2;
                while (k < N) {
                    bs.set(k);
                    k += i;
                }
            }
        }

        Scanner cin = new Scanner(System.in);
        int n;
        while (0 != (n = cin.nextInt())) {
            int sum = 0;
            for (int i = 0; i < MAX; i++) {
                int t = 0;
                // 计算从i开始、连续素数和为n的终点位置j
                for (int j = i; j < MAX; j++) {
                    t += prime[j];
                    // 超过n的时候要跳出,因为后面的值更大
                    if (t >= n) {
                        if (t == n)
                            sum++;
                        break;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}