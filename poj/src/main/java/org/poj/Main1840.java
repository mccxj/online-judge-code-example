package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Eqs(http://poj.org/problem?id=1840)
 * <p/>
 * <p/>
 * 对于a1*x1^3 + a2*x2^3 + a3*x3^3 + a4*x4^3 + a5*x5^3=0
 * 给出ai,求xi的解的个数(xi∈[-50,50], xi != 0, any i∈{1,2,3,4,5})
 */
public class Main1840 {
    private static final int[][] CALS =
            new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}
            };

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int[] x = new int[5];

        int solution = 0;
        for (int i = 0; i < 5; i++)
            x[i] = cin.nextInt();

        // 计算ai*3,ai∈[1, 50]
        int[] club = new int[50];
        for (int i = 1; i <= 50; i++)
            club[i - 1] = i * i * i;

        // 把等式分成左边3个右边2个来分别计算
        // 计算左边的
        int t = 0;
        int[] s = new int[1000000];
        for (int i = 1; i <= 50; i++) {
            int s1 = x[0] * club[i - 1];
            for (int j = 1; j <= 50; j++) {
                int s2 = x[1] * club[j - 1];
                for (int k = 1; k <= 50; k++) {
                    int s3 = x[2] * club[k - 1];
                    s[t++] = s1 + s2 + s3;
                    s[t++] = s1 + s2 - s3;
                    s[t++] = s1 - s2 + s3;
                    s[t++] = s1 - s2 - s3;
                    s[t++] = -s1 + s2 + s3;
                    s[t++] = -s1 + s2 - s3;
                    s[t++] = -s1 - s2 + s3;
                    s[t++] = -s1 - s2 - s3;
                }
            }
        }

        Arrays.sort(s);//先排序，便于两分查找
        for (int i = 1; i <= 50; i++) {
            int s3 = x[3] * club[i - 1];
            for (int j = 1; j <= 50; j++) {
                int s4 = x[4] * club[j - 1];
                int pos;
                for (int k = 0; k < 4; k++) {
                    int ss = s3 * CALS[k][0] + s4 * CALS[k][1];
                    if ((pos = Arrays.binarySearch(s, ss)) >= 0) {
                        int p = pos;
                        solution++;
                        while (p-- > 0 && s[p] == ss)
                            solution++;
                        p = pos;
                        while (p++ < 999999 && s[p] == ss)
                            solution++;
                    }
                }
            }
        }

        System.out.println(solution);
    }
}