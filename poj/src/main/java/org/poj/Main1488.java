package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TEX Quotes(http://poj.org/problem?id=1488)
 * <p/>
 * <p/>
 * 阅读题,边输入边输出即可
 */
public class Main1488 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        String[] r = {"``", "''"};
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while ((s = reader.readLine()) != null) {
            sb.setLength(0);
            for (int i = 0; i < s.length(); i++) {
                if ('"' == s.charAt(i)) {
                    sb.append(r[idx]);
                    idx = (idx + 1) % 2;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            System.out.println(sb);
        }
    }
}