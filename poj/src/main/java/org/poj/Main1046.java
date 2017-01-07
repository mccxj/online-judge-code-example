package org.poj;

import java.util.Scanner;

/**
 * Color Me Less(http://poj.org/problem?id=1046)
 * 
 * <p>
 * 计算点的最近距离,计算后面的点和前面16个点钟的哪个距离最近
 */
public class Main1046 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int[][] c = new int[50][3];
        int count = 0;
        do {
            int i = cin.nextInt();
            int j = cin.nextInt();
            int k = cin.nextInt();
            if (i == -1 && j == -1 && k == -1)
                break;

            c[count++] = new int[]{i, j, k};
        } while (true);

        for (int i = 16; i < count; i++) {
            int min = distance(c[i], c[0]);
            int mi = 0;
            for (int j = 1; j < 16; j++) {
                int d = distance(c[i], c[j]);
                if (d < min) {
                    min = d;
                    mi = j;
                }
            }
            String msg = "(" + c[i][0] + "," + c[i][1] + "," + c[i][2] + ") maps to (" + c[mi][0] + "," + c[mi][1] + "," + c[mi][2] + ")";
            System.out.println(msg);
        }

    }

    private static int distance(int[] s, int[] d) {
        return (s[0] - d[0]) * (s[0] - d[0]) + (s[1] - d[1]) * (s[1] - d[1]) + (s[2] - d[2]) * (s[2] - d[2]);
    }
}