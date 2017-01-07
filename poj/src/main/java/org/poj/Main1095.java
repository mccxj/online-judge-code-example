package org.poj;

import java.util.Scanner;

/**
 * Trees Made to Order(http://poj.org/problem?id=1095)
 * <p/>
 * <p/>
 * 找规律,先找出N个X可以表示多少个数,在计算出是要找其中的第几个,然后计算左右子树进行递归
 */
public class Main1095 {
    static int[] f = new int[20];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        f[0] = 1;
        f[1] = 1;

        int sum = 0;
        for (int i = 2; i < 20; i++) {
            int s = 0;
            for (int k = 0; k < i; k++)
                s += f[k] * f[i - k - 1];
            f[i] = s;
            sum += f[i];
        }

        int n;
        while ((n = cin.nextInt()) != 0) {
            // 找到需要多少个来表示
            sum = 0;
            int i;
            for (i = 1; i < 20; i++) {
                sum += f[i];
                if (sum >= n)
                    break;
            }
            // 需要i个来表示
            sum -= f[i];
            // 第i的idx个
            int idx = n - sum;
            System.out.println(print(i, idx));
        }
    }

    private static String print(int i, int idx) {
        if (i == 1)
            return "X";
        if (i == 2 && idx == 1)
            return "X(X)";
        if (i == 2 && idx == 2)
            return "(X)X";
        int sum = 0;
        int k;
        for (k = 0; k < i; k++) {
            if (sum + f[k] * f[i - k - 1] >= idx)
                break;
            sum += f[k] * f[i - k - 1];
        }
        // 左边有k个,有变有k-i-1个
        sum = idx - sum;
        int l = (sum - 1) / f[i - k - 1] + 1;
        int r = (sum - 1) % f[i - k - 1] + 1;
        if (k == 0)
            return "X(" + print(i - k - 1, r) + ")";
        else if (i - k - 1 == 0)
            return "(" + print(k, l) + ")X";
        else
            return "(" + print(k, l) + ")X(" + print(i - k - 1, r) + ")";
    }
}