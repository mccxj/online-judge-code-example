package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * StuPId(http://poj.org/problem?id=2498)
 * <p/>
 * <p/>
 * 简单题,但是注意读清楚题意
 */
public class Main2498 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            char[] cs = reader.readLine().toCharArray();
            int sum = 0;
            int idx = -1;
            int[] m = {9, 3, 7};
            for (int j = cs.length - 1; j >= 0; j--) {
                if (cs[j] == '?') {
                    idx = j;
                } else {
                    sum += m[(cs.length - 1 - j) % 3] * (cs[j] - '0');
                }
            }
            assert idx != -1;

            for (int j = 0; j <= 9; j++) {
                if ((sum + m[(cs.length - 1 - idx) % 3] * j) % 10 == 0) {
                    System.out.printf("Scenario #%d:", i + 1);
                    System.out.println();
                    cs[idx] = (char) ('0' + j);
                    System.out.println(String.valueOf(cs));
                    System.out.println();
                    break;
                }
            }
        }
    }
}