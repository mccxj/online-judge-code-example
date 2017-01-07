package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Electrical Outlets(http://poj.org/problem?id=2636)
 * <p/>
 * <p/>
 * 简单题,不解释
 */
public class Main2636 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(token.nextToken());
            int max = -m + 1;// 要减去多个插座之间的连线
            while (m-- > 0) {
                max += Integer.parseInt(token.nextToken());
            }
            System.out.println(max);
        }
    }
}