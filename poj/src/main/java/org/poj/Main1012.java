package org.poj;

import java.util.Scanner;

/**
 * Joseph(http://poj.org/problem?id=1012)
 * <p/>
 * <p/>
 * Joseph环问题,使用整数位移的方式枚举就可以了,减少一个相当于后面的向前移动一个位置
 */
public class Main1012 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int k;
        int[] mm = {0, 2, 7, 5, 30, 169, 441, 1872, 7632, 1740, 93313, 459901, 1358657, 2504881};
        
        /*
        int[] mm = new int[14];
        for (k = 1; k < 14; k++) {
            m = k;
            do {
                t = 2 * k;// 剩余的人的个数,应该大于等于k
                p = 0;// 表示当前开始计数的位置
                // 计算k次,找到k个坏人
                for (i = 0; i < k; i++) {
                    u = m % t;
                    p = (p + u) % t;// 找到下一个位置
                    if (p < k)
                        break;// 失败
                    t--;// 减少一个位置
                }

                // 成功找到最小的m
                if (i == k) {
                    mm[k] = m + 1;
                    break;
                }
            } while (m++ > 0);
        }
        */

        while ((k = cin.nextInt()) != 0) {
            System.out.println(mm[k]);
        }
    }
}