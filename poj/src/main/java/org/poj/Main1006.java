package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 生理周期(http://poj.org/problem?id=1006)
 * <p/>
 * <p/>
 * 数学题,同余
 */
public class Main1006 {
    private static final int P = 23;
    private static final int E = 28;
    private static final int I = 33;

    public static void main(String args[]) throws IOException {
        int p, e, i, kp, ke, ki, d;
        StringTokenizer token;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int seq = 1;
        while (true) {
            String str = reader.readLine();

            token = new StringTokenizer(str);
            p = Integer.parseInt(token.nextToken());//体力
            e = Integer.parseInt(token.nextToken());//情感
            i = Integer.parseInt(token.nextToken());//智力
            d = Integer.parseInt(token.nextToken());

            if (p == -1 && e == -1 && i == -1 && d == -1)
                break;
            // 找到第一次出现的时间
            kp = p % P;
            ke = e % E;
            ki = i % I;

            // 每次增加一个I值,去匹配体力p和情感e
            int ds;
            if (ki == 0) {
                ds = I;
            } else if (d < ki) {
                ds = ki;
            } else {
                ds = ((d - ki - 1) / I + 1) * I + ki;
            }

            while (true) {
                if (ds % P == kp && ds % E == ke) {
                    System.out.printf("Case %d: the next triple peak occurs in %d days.", seq, ds - d);
                    System.out.println();
                    break;
                }
                ds += I;
            }
            seq++;
        }
    }
}