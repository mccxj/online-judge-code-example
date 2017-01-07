package org.poj;

import java.util.Scanner;

/**
 * Distance on Chessboard(http://poj.org/problem?id=1657)
 * <p/>
 * <p/>
 * 国际象棋走子最少步数
 */
public class Main1657 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            // 获取坐标
            String start = cin.next();
            int sx = start.charAt(0) - 'a';
            int sy = start.charAt(1) - '1';
            String end = cin.next();
            int ex = end.charAt(0) - 'a';
            int ey = end.charAt(1) - '1';

            // 起始位置和结束位置是相同的时候
            if (sx == ex && sy == ey) {
                System.out.println("0 0 0 0");
                continue;
            }

            int absx = Math.abs(sx - ex);
            int absy = Math.abs(sy - ey);
            int w = Math.max(absx, absy);//王
            int h = (absx == 0 || absy == 0 || absx == absy) ? 1 : 2;//后
            int c = (absx == 0 || absy == 0) ? 1 : 2;//车

            if (absx == absy) {
                System.out.println(w + " " + h + " " + c + " 1");
            } else if ((absx + absy) % 2 == 0) {
                System.out.println(w + " " + h + " " + c + " 2");
            } else {
                System.out.println(w + " " + h + " " + c + " Inf");
            }
        }
    }
}