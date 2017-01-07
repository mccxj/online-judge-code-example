package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IMMEDIATE DECODABILITY(http://poj.org/problem?id=1056)
 * <p/>
 * <p/>
 * 字符串操作简单题
 */
public class Main1056 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        boolean ok = true;
        int len = 0;
        int seq = 1;
        String[] cs = new String[8];
        while ((s = reader.readLine()) != null) {
            if (!"9".equals(s)) {
                cs[len++] = s;
                continue;
            }
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (cs[i].startsWith(cs[j]) || cs[j].startsWith(cs[i])) {
                        ok = false;
                        i = len;
                        break;
                    }
                }
            }

            if (ok)
                System.out.println("Set " + seq + " is immediately decodable");
            else
                System.out.println("Set " + seq + " is not immediately decodable");
            len = 0;
            seq++;
            ok = true;
        }
    }
}