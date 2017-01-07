package org.poj;

import java.util.Scanner;

/**
 * Humble Numbers(http://poj.org/problem?id=2247)
 * <p/>
 * <p/>
 * 序列生成题目,和3176和1163是一样的道理
 */
public class Main2247 {
    public static void main(String args[]) {
        int[] idx = {0, 0, 0, 0};
        int[] n = {2, 3, 5, 7};
        String[] r = {"st", "nd", "rd"};
        int[] num = new int[5842];
        num[0] = 1;
        for (int i = 1; i < num.length; i++) {
            int min = num[idx[0]] * 2;
            for (int j = 1; j < 4; j++)
                if (num[idx[j]] * n[j] < min)
                    min = num[idx[j]] * n[j];
            num[i] = min;
            for (int j = 0; j < 4; j++)
                if (num[idx[j]] * n[j] == min)
                    idx[j]++;
        }

        Scanner cin = new Scanner(System.in);
        int nn;
        while ((nn = cin.nextInt()) != 0) {
            if (nn % 100 == 11 || nn % 100 == 12 || nn % 100 == 13 || nn % 10 < 1 || nn % 10 > 3)
                System.out.printf("The %dth humble number is %d.", nn, num[nn - 1]);
            else
                System.out.printf("The %d%s humble number is %d.", nn, r[nn % 10 - 1], num[nn - 1]);
            System.out.println();
        }
    }
}