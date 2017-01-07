package org.poj;

import java.util.Scanner;

/**
 * Cabric Number Problem(http://poj.org/problem?id=1350)
 * <p/>
 * <p/>
 * 模拟题,相当于高精度
 */
public class Main1350 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        String s;
        while (!"-1".equals(s = cin.next())) {
            System.out.println("N=" + s + ":");

            if (s.length() != 4 || Integer.parseInt(s, 10) % 1111 == 0) {
                System.out.println("No!!");
                continue;
            }

            int time = 0;
            while (true) {
                char[] cs = s.toCharArray();
                // 从小到大排序
                for (int i = 0; i < s.length() - 1; i++) {
                    for (int j = i + 1; j < s.length(); j++) {
                        if (cs[i] > cs[j]) {
                            char t = cs[i];
                            cs[i] = cs[j];
                            cs[j] = t;
                        }
                    }
                }

                int min = 0;
                int max = 0;
                for (int i = 0; i < s.length(); i++) {
                    min += (cs[i] - '0') * Math.pow(10, s.length() - i - 1);
                    max += (cs[i] - '0') * Math.pow(10, i);
                }

                int st = max - min;
                System.out.println(max + "-" + min + "=" + st);

                time++;
                if (st == 6174 || st == 0) {
                    System.out.println("Ok!! " + time + " times");
                    break;
                }
                s = String.valueOf(st);
            }
        }
    }
}