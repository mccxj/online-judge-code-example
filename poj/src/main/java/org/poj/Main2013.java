package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Symmetric Order(http://poj.org/problem?id=2013)
 * <p/>
 * <p/>
 * 按规定顺序输出字符串,简单题
 */
public class Main2013 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pos, n;
        int seq = 1;

        while ((n = Integer.parseInt(reader.readLine())) != 0) {
            String[] strs = new String[n];
            for (int i = 0; i < n; i++)
                strs[i] = reader.readLine();

            System.out.println("SET " + seq);

            // 正向输出
            for (pos = 0; pos < n; pos += 2)
                System.out.println(strs[pos]);
            // 反向输出
            pos = pos == n ? n - 1 : n - 2;
            for (; pos >= 0; pos -= 2)
                System.out.println(strs[pos]);
            seq++;
        }
    }
}