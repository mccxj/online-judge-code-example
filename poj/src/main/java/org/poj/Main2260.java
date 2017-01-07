package org.poj;

import java.util.Scanner;

/**
 * Error Correction(http://poj.org/problem?id=2260)
 * <p/>
 * <p/>
 * 简单数学题,统计各行各列中1的个数
 */
public class Main2260 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = Integer.parseInt(cin.nextLine())) != 0) {
            int[][] m = new int[n][n];
            int[] row = new int[n];//记录行的1个数
            int[] col = new int[n];//记录列的1个数
            for (int i = 0; i < n; i++) {
                String s = cin.nextLine();
                for (int j = 0; j < n; j++)
                    m[i][j] = s.charAt(j * 2) - '0';
            }

            // 统计行和列的1的个数
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (m[i][j] == 1)
                        row[i]++;
                    if (m[j][i] == 1)
                        col[i]++;
                }
            }

            boolean canChange = true;
            int oddrow = -1;
            int oddcol = -1;
            for (int i = 0; i < n; i++) {
                if (row[i] % 2 != 0) {
                    //出现多个奇数个数的话,没办法处理
                    if (oddrow != -1) {
                        canChange = false;
                        break;
                    }
                    oddrow = i;
                }
                if (col[i] % 2 != 0) {
                    //出现多个奇数个数的话,没办法处理
                    if (oddcol != -1) {
                        canChange = false;
                        break;
                    }
                    oddcol = i;
                }
            }

            if (!canChange)
                System.out.println("Corrupt");
            else if (oddrow == -1 && oddcol == -1)
                System.out.println("OK");
            else if (oddrow != -1 && oddcol != -1)
                System.out.println("Change bit (" + (oddrow + 1) + "," + (oddcol + 1) + ")");
            else
                System.out.println("Corrupt");
        }
    }
}