package org.poj;


import java.util.Scanner;

/**
 * Prime Distance(http://poj.org/problem?id=2689)
 * <p/>
 * <p/>
 * 素数筛选题,直接筛选法
 */
public class Main2689 {
    public static void main(String[] args) {
        long a, b;
        int i, j;
        boolean isPrime;
        int[] prime = new int[4792];
        int curr = 0;
        prime[curr++] = 2;
        prime[curr++] = 3;
        int m = (int) Math.sqrt(Integer.MAX_VALUE);
        for (i = 5; i <= m; i += 2) {
            isPrime = true;
            for (j = 3; j <= (int) Math.sqrt(i); j += 2)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            if (isPrime)
                prime[curr++] = i;
        }

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            a = cin.nextLong();
            b = cin.nextLong();
            // false表示是素数
            boolean[] pm = new boolean[(int) (b - a + 1)];
            // 要过滤一下1
            if (a == 1)
                pm[0] = true;

            for (i = 0; i < curr; i++) {
                long s = (a + prime[i] - 1) / prime[i] * prime[i];
                if (s == prime[i])
                    s += prime[i];
                while (s <= b && s > 0) {
                    pm[(int) (s - a)] = true;
                    s += prime[i];
                }
            }

            int min = Integer.MAX_VALUE;
            int mina = -1;
            int minb = -1;
            int max = Integer.MIN_VALUE;
            int maxa = -1;
            int maxb = -1;

            for (i = 0; i < pm.length; i++) {
                if (!pm[i])
                    break;
            }

            if (i == pm.length) {
                System.out.println("There are no adjacent primes.");
                continue;
            }

            int priv = i;
            for (j = i + 1; j < pm.length; j++) {
                if (!pm[j]) {
                    if (j - priv < min) {
                        mina = priv;
                        minb = j;
                        min = j - priv;
                    }
                    if (j - priv > max) {
                        maxa = priv;
                        maxb = j;
                        max = j - priv;
                    }
                    priv = j;
                }
            }

            if (mina == -1 || minb == -1 || maxa == -1 || maxb == -1) {
                System.out.println("There are no adjacent primes.");
            } else {
                System.out.printf("%d,%d are closest, %d,%d are most distant.", mina + a, minb + a, maxa + a, maxb + a);
                System.out.println();
            }
        }
    }
}