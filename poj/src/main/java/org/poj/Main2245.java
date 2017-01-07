package org.poj;

import java.util.Scanner;

/**
 * Lotto(http://poj.org/problem?id=2245)
 * <p/>
 * <p/>
 * 全排列题目,使用递归
 */

public class Main2245 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int i;
        int n = cin.nextInt();
        while (n != 0) {
            int[] num = new int[n];
            for (i = 0; i < n; i++)
                num[i] = cin.nextInt();

            int[] seq = new int[6];
            boolean[] visit = new boolean[n];
            bfs(num, visit, 0, -1, seq, seq.length);

            n = cin.nextInt();
            if (n != 0)
                System.out.println();
        }
    }

    private static void bfs(int[] num, boolean[] visit, int curr, int idx, int[] seq, int len) {
        if (curr == len) {
            System.out.print(seq[0]);
            for (int i = 1; i < len; i++)
                System.out.printf(" " + seq[i]);
            System.out.println();
            return;
        }

        for (int i = idx + 1; i < num.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                seq[curr] = num[i];
                bfs(num, visit, curr + 1, i, seq, len);
                visit[i] = false;
            }
        }
    }
}