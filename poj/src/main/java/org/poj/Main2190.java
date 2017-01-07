package org.poj;

import java.util.Scanner;

/**
 * ISBN(http://poj.org/problem?id=2190)
 * <p/>
 * <p/>
 * 简单题,要求计算出来可以被11整除,穷举逐个判断
 */
public class Main2190 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();

        int sum = 0;
        int idx = -1;
        for (int i = 0; i < 10; i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                sum += 10 * (10 - i);
            } else if (c == '?') {
                idx = i;
            } else {
                sum += (c - '0') * (10 - i);
            }
        }
        assert idx != -1;

        //最后一位可以填写X
        int n = idx == 9 ? 10 : 9;
        for (int i = 0; i <= n; i++) {
            // 遍历进行判断
            if ((sum + (10 - idx) * i) % 11 == 0) {
                // 用不了三元,不然X会被当成整形
                if (i == 10)
                    System.out.println('X');
                else
                    System.out.println(i);
                return;
            }
        }
        // 没有找到合适的数字
        System.out.println(-1);
    }
}