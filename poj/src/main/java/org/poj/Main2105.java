package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * IP Address(http://poj.org/problem?id=2105)
 * <p/>
 * <p/>
 * 公式题,IP二进制转换
 */
public class Main2105 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String ipstr = reader.readLine();
            int a = Integer.parseInt(ipstr.substring(0, 8), 2);
            int b = Integer.parseInt(ipstr.substring(8, 16), 2);
            int c = Integer.parseInt(ipstr.substring(16, 24), 2);
            int d = Integer.parseInt(ipstr.substring(24, 32), 2);

            System.out.printf("%d.%d.%d.%d", a, b, c, d);
            System.out.println();
        }
    }
}