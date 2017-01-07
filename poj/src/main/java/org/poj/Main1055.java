package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * BULK MAILING(http://poj.org/problem?id=1000)
 * <p/>
 * <p/>
 * 思路不难但很繁琐的题目,使用数值数组来存储
 */
public class Main1055 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String s;
        int t, k;
        List<String> invalid = new ArrayList<String>();
        int[] zip = new int[100000];// 保存五位的zipcode
        int[] xzip = new int[1000];// 保存前三位的zipcode
        int totalLetters = 0;
        int totalBundles = 0;
        while ((s = reader.readLine()) != null) {
            int n = toInt(s);
            if (n == -1) {
                if (!invalid.contains(s))
                    invalid.add(s);
                continue;
            }

            totalLetters++;
            zip[n]++;
        }

        System.out.println("ZIP         LETTERS     BUNDLES");
        System.out.println();
        for (int i = 1; i < 100000; i++) {
            if (zip[i] >= 10) {
                // 只有16~19的不能完整打包
                if (zip[i] > 15 && zip[i] < 20) {
                    k = 15;
                    t = 1;
                } else {
                    k = zip[i];
                    t = (zip[i] + 14) / 15;
                }
                totalBundles += t;
                zip[i] -= k;
                System.out.printf("%05d%12d%12d", i, k, t);
                System.out.println();
            }
            xzip[i / 100] += zip[i];
        }

        System.out.println();
        for (int i = 0; i < 1000; i++) {
            if (xzip[i] >= 10) {
                // 只有16~19的不能完整打包
                if (xzip[i] > 15 && xzip[i] < 20) {
                    k = 15;
                    t = 1;
                } else {
                    k = xzip[i];
                    t = (xzip[i] + 14) / 15;
                }
                totalBundles += t;
                System.out.printf("%03dxx%12d%12d", i, k, t);
                System.out.println();

                // 回头再更新一下剩余的数量
                for (int j = 0; j < 100; j++) {
                    int m = i * 100 + j;
                    if (k >= zip[m]) {
                        k -= zip[m];
                        zip[m] = 0;
                    } else {
                        zip[m] -= k;
                        break;
                    }
                }
            }
        }

        System.out.println();
        for (int i = 1; i < 100000; i++) {
            if (zip[i] != 0) {
                System.out.printf("%05d%12d%12d", i, zip[i], 0);
                System.out.println();
            }
        }

        System.out.println();
        System.out.printf("TOTALS%11d%12d", totalLetters, totalBundles);
        System.out.println();
        System.out.println();
        System.out.println("INVALID ZIP CODES");
        System.out.println();
        for (String ss : invalid)
            System.out.println(ss);
    }

    private static int toInt(String s) {
        int len = s.length();
        if (len != 5)
            return -1;
        int t, n = 0;
        for (int i = 0; i < len; i++) {
            t = s.charAt(i) - '0';
            if (t >= 0 && t <= 9)
                n = n * 10 + t;
            else
                return -1;
        }

        if (n == 0)
            return -1;
        return n;
    }
}