package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Copier Reduction(http://poj.org/problem?id=2707)
 * <p/>
 * <p/>
 * 简单题,不解释
 */
public class Main2707 {
    public static void main(String args[]) throws IOException {
        int t, a, b, c, d;// a*b是图片大小,c*d是纸张大小
        StringTokenizer token;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (!(str = reader.readLine()).startsWith("0")) {
            token = new StringTokenizer(str);
            a = Integer.parseInt(token.nextToken());
            b = Integer.parseInt(token.nextToken());
            c = Integer.parseInt(token.nextToken());
            d = Integer.parseInt(token.nextToken());

            // 判断是否需要转动一下
            if ((a - b) * (c - d) < 0) {
                t = d;
                d = c;
                c = t;
            }
            System.out.print(Math.min(100, Math.min(c * 100 / a, d * 100 / b)));
            System.out.println('%');
        }
    }
}