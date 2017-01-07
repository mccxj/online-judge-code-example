package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 字符串题目,暴力就可以了
 */
public class Main2406 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).startsWith(".")) {
            int len = s.length();
            for (int i = 1; i <= len; i++) {
                if (len % i == 0) {
                    if (match(i, s)) {
                        System.out.println(len / i);
                        break;
                    }
                }
            }
        }
    }

    private static boolean match(int al, String s) {
        int times = s.length() / al;
        for (int i = 1; i < times; i++) {
            for (int j = 0; j < al; j++)
                if (s.charAt(j) != s.charAt(j + i * al))
                    return false;
        }
        return true;
    }
}