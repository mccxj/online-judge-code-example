package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Eva's Problem(http://poj.org/problem?id=1658)
 * <p/>
 * <p/>
 * 等差或等比数列判断,不解释
 */
public class Main1658 {
    public static void main(String args[]) throws IOException {
        StringTokenizer token;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        while (n-- > 0) {
            String t = reader.readLine();
            token = new StringTokenizer(t);
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());

            if (b - a == c - b && d - c == c - b) {
                System.out.println(t + " " + (2 * d - c));
            } else {
                System.out.println(t + " " + d * d / c);
            }
        }
    }
}
