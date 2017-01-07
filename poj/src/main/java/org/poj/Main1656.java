package org.poj;

import java.util.Scanner;

/**
 * Counting Black(http://poj.org/problem?id=1656)
 * <p/>
 * <p/>
 * 直接模拟即可
 */
public class Main1656 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x, y, k;
        String cmd;
        // white:false,black:false
        boolean[][] board = new boolean[101][101];

        int n = cin.nextInt();
        while (n-- > 0) {
            cmd = cin.next();
            x = cin.nextInt();
            y = cin.nextInt();
            k = cin.nextInt();
            if ("TEST".equals(cmd)) {
                int total = 0;
                for (int i = x; i < x + k; i++)
                    for (int j = y; j < y + k; j++)
                        if (board[i][j])
                            total++;
                System.out.println(total);
            } else {
                boolean isblack = "BLACK".equals(cmd);
                for (int i = x; i < x + k; i++)
                    for (int j = y; j < y + k; j++)
                        board[i][j] = isblack;
            }
        }
    }
}