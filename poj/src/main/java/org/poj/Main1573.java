package org.poj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Robot Motion(http://poj.org/problem?id=1573)
 * <p/>
 * <p/>
 * 模拟题,直接模拟即可
 */
public class Main1573 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        StringTokenizer token;
        int row, col, pos, px, py, step;
        while (true) {
            token = new StringTokenizer(cin.nextLine());
            row = Integer.parseInt(token.nextToken());
            col = Integer.parseInt(token.nextToken());
            pos = Integer.parseInt(token.nextToken());
            if (row == 0 && col == 0 && pos == 0)
                break;

            // 初始化地图
            char[][] cs = new char[row][col];
            for (int i = 0; i < row; i++) {
                cs[i] = cin.nextLine().toCharArray();
            }

            // 初始化坐标
            px = 0;
            py = pos - 1;
            step = 0;
            int[][] visit = new int[row][col];

            boolean exit = false;
            while (visit[px][py] == 0) {
                visit[px][py] = ++step;
                switch (cs[px][py]) {
                    case 'N':
                        px--;
                        break;
                    case 'S':
                        px++;
                        break;
                    case 'E':
                        py++;
                        break;
                    case 'W':
                        py--;
                        break;
                }
                if (px < 0 || px >= row || py < 0 || py >= col) {
                    exit = true;
                    break;
                }
            }

            if (exit)
                System.out.println(step + " step(s) to exit");
            else
                System.out.println((visit[px][py] - 1) + " step(s) before a loop of " + (step - visit[px][py] + 1) + " step(s)");
        }
    }
}