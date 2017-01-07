package org.poj;

import java.util.Scanner;

/**
 * Tri Tiling(http://poj.org/problem?id=2663)
 * <p/>
 * <p/>
 * 找规律,根据公式推理出来
 * T(奇数) = 0
 * T(0) = 1
 * T(2) = 3
 * T(n) = 3*T(n-2) + 2*(T(n-4)+T(n-6)...+T(0))
 * 则有T(n-2) = 3*T(n-4) + 2*(T(n-6)+T(n-8)...+T(0))
 * 相减得T(n)-T(n-2) = 3*T(n-2) - T(n-4),最终得T(n) = 4*T(n-2) - T(n-4)
 */
public class Main2663 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        int[] t = new int[31];
        t[0] = 1;
        t[2] = 3;
        for (int i = 4; i < 31; i += 2)
            t[i] = 4 * t[i - 2] - t[i - 4];

        while ((n = cin.nextInt()) != -1) {
            System.out.println(t[n]);
        }
    }
}