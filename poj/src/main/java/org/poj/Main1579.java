package org.poj;

import java.util.Scanner;

/**
 * 递归题目,记忆化搜索
 */
public class Main1579 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int[][][] w = new int[21][21][21];
        boolean[][][] visit = new boolean[21][21][21];

        w[0][0][0] = 1;
        visit[0][0][0] = true;

        for (int i = 0; i < 21; i++)
            for (int j = 0; j < 21; j++)
                for (int k = 0; k < 21; k++)
                    cal(i, j, k, w, visit);

        while (true) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            if (a == -1 && b == -1 && c == -1)
                break;
            System.out.printf("w(%d, %d, %d) = %d", a, b, c, cal(a, b, c, w, visit));
            System.out.println();
        }

    }

    private static int cal(int a, int b, int c, int[][][] w, boolean[][][] visit) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20) {
            a = 20;
            b = 20;
            c = 20;
        }

        if (!visit[a][b][c]) {
            if (a < b && b < c)
                w[a][b][c] = cal(a, b, c - 1, w, visit) + cal(a, b - 1, c - 1, w, visit) - cal(a, b - 1, c, w, visit);
            else
                w[a][b][c] = cal(a - 1, b, c, w, visit) + cal(a - 1, b - 1, c, w, visit) + cal(a - 1, b, c - 1, w, visit) - cal(a - 1, b - 1, c - 1, w, visit);
            visit[a][b][c] = true;
        }
        return w[a][b][c];
    }
}