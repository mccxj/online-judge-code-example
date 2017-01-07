package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Moving Tables(http://poj.org/problem?id=1083)
 * 
 * <p>
 * 计算移动桌子的最少时间,只要找到最多桌子经过的房门即可<br/>
 * 使用一个数组每个房门的经过次数,计算最大的值
 */
public class Main1083 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();
        int[] rooms = new int[201];
        while (num-- > 0) {
            Arrays.fill(rooms, 0);
            int cases = cin.nextInt();
            while (cases-- > 0) {
                // 映射到对应的数组
                int s = (cin.nextInt() + 1) / 2;
                int e = (cin.nextInt() + 1) / 2;

                // 保证s<=e
                if (s > e) {
                    int tmp = e;
                    e = s;
                    s = tmp;
                }

                while (s <= e) {
                    rooms[s]++;
                    s++;
                }
            }
            int max = 0;
            for (int r : rooms) {
                if (r > max) {
                    max = r;
                }
            }
            System.out.println(max * 10);
        }
    }
}