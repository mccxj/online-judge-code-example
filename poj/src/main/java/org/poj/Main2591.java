package org.poj;

import java.util.Scanner;

/**
 * Set Definition(http://poj.org/problem?id=2591)
 * <p/>
 * <p/>
 * 数学问题,用两个标识指代2x+1,3x+1的x的位置
 */
public class Main2591 {
    private static final int MAX = 10000000;

    public static void main(String args[]) {
        int[] num = new int[MAX];
        num[0] = 1;

        int m1, m2;
        int t1 = 0;//2x+1的当前x标示位
        int t2 = 0;//3x+1的当前x标示位
        //寻找n个数据
        for (int i = 1; i < MAX; i++) {
            m1 = 2 * num[t1] + 1;
            m2 = 3 * num[t2] + 1;
            if (m1 > m2) {
                num[i] = m2;
                t2++;
            } else if (m1 < m2) {
                num[i] = m1;
                t1++;
            } else {
                num[i] = m1;
                t1++;
                t2++;
            }
        }

        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            System.out.println(num[cin.nextInt() - 1]);
        }
    }
}