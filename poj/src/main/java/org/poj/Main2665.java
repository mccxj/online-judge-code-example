package org.poj;

import java.util.Scanner;

/**
 * Trees(http://poj.org/problem?id=2665)
 * <p/>
 * <p/>
 * 简单题目,不解释
 */
public class Main2665 {
    public static void main(String args[]) {
        int road, n, start, end;// road是总距离,start和end是要划为铁路的开始和结束位置
        Scanner cin = new Scanner(System.in);
        while (true) {
            road = cin.nextInt();
            n = cin.nextInt();

            if (road == 0)
                break;

            while (n-- > 0) {
                start = cin.nextInt();
                end = cin.nextInt();
                road -= end - start + 1;// 题目表示没有出现区间重叠
            }
            System.out.println(road + 1);// 加1得到总棵数
        }
    }
}