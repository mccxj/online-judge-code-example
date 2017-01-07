package org.poj;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * The Pilots Brothers' refrigerator(http://poj.org/problem?id=2965)
 * 
 * <p>
 * 开门锁,参考Flip Game(POJ1753)翻转棋子,不过TLE,很悲剧,可能是Special Judge造成的<br/>
 * 采用了另外一种方式(http://poj.org/showmessage?message_id=108690)<br/>
 * 开一个4X4的Bool数组，开始全为false.如果输入(i,j)处有"+"，将该行该列取反。最后有多少true就是最少步数。输出为true的坐标就是步骤
 */
public class Main2965 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        boolean[][] pos = new boolean[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                pos[i][j] = false;

        for (int i = 0; i < 4; i++) {
            char[] cs = cin.next().toCharArray();
            for (int j = 0; j < 4; j++) {
                if (cs[j] == '+') {
                    for (int t = 0; t < 4; t++) {
                        pos[t][j] = !pos[t][j];
                        pos[i][t] = !pos[i][t];
                    }
                    pos[i][j] = !pos[i][j];
                }
            }
        }

        int len = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pos[i][j])
                    len++;
            }
        }
        System.out.println(len);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (pos[i][j])
                    System.out.println((i + 1) + " " + (j + 1));
            }
        }

    }
}