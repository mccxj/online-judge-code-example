package org.poj;

import java.util.Scanner;

/**
 * An Easy Problem(http://poj.org/problem?id=2453)
 * <p/>
 * <p/>
 * 二进制题目,从最后一个1开始向前走,一直跟最后一位调换直到遇到0,再调换一次即可
 */
public class Main2453 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = cin.nextInt()) != 0) {
            char[] cs = ("0" + Integer.toBinaryString(n)).toCharArray();
            int len = cs.length;

            // 找到最后一个1的位置
            int last = -1;
            for (int i = len - 1; i >= 0; i--) {
                if (cs[i] != '0') {
                    last = i;
                    break;
                }
            }
            assert last != -1;

            int idx = len - 1;//用于交换使用
            while (last >= 0 && cs[last] != '0') {
                if (cs[idx] == '0') {
                    cs[last] = '0';
                    cs[idx] = '1';
                }
                last--;
                idx--;
            }
            assert cs[last] == '0';
            // 把0和idx最开始的1进行交换
            cs[last] = '1';
            cs[idx + 1] = '0';

            System.out.println(Integer.parseInt(String.valueOf(cs), 2));
        }
    }
}