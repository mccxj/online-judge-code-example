package org.poj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 滑雪(http://poj.org/problem?id=1088)
 * 
 * <p>
 * 计算最长滑雪路径
 * 
 * <p>
 * Accepted 5580K 1625MS Java 2048B 2013-04-06 18:14:05<br/>
 * 方法1: 对所有位置的高度从小到大进行排序,从高度低的位置开始,计算它的最长滑雪路径(找周围高度比它小并且路径最长的,加1即可).
 * 使用贪心法,就可以计算出所有位置的最长滑雪路径,再从中找到个最大的就是结果.
 * 
 * <p>
 * Accepted 5332K 1704MS Java 4752B 2013-04-06 19:50:04<br/>
 * 方法2: 使用动态规划技术<br/>
 * hs[i][j] = max{hs[i-1][j], hs[i][j-1], hs[i+1][j], hs[i][j+1]} + 1,
 * 当hss[i][j]>hss[x][y]
 * 
 * 由于没法一次跑出结果,用了一个循环,不停的计算最长路径,直到没有变化为止<br/>
 * 为了提高效率,把4边的判断分为左上和右下两部分进行处理
 */
public class Main1088 {
    public static void main(String args[]) {
        run2();
    }

    private static void run1() {
        Scanner cin = new Scanner(System.in);
        int r = cin.nextInt();// 行数
        int c = cin.nextInt();// 列数

        List<int[]> heights = new ArrayList<int[]>();// 用于对高度进行排序
        int[][] hs = new int[r][c];// 保留当前位置的最长滑雪路径
        int[][] hss = new int[r][c];// 保留当前位置的高度
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                hs[i][j] = 0;
                int h = cin.nextInt();
                hss[i][j] = h;
                heights.add(new int[]{h, i, j});
            }
        }

        // 对高度进行从小到大排序
        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int mm = 1;
        for (int[] xx : heights) {
            int rr = xx[1];
            int cc = xx[2];
            int max = 0;

            // 找周围高度比它小并且路径最长的
            if (rr - 1 >= 0 && xx[0] > hss[rr - 1][cc] && hs[rr - 1][cc] > max)
                max = hs[rr - 1][cc];
            if (cc - 1 >= 0 && xx[0] > hss[rr][cc - 1] && hs[rr][cc - 1] > max)
                max = hs[rr][cc - 1];
            if (rr + 1 < r && xx[0] > hss[rr + 1][cc] && hs[rr + 1][cc] > max)
                max = hs[rr + 1][cc];
            if (cc + 1 < c && xx[0] > hss[rr][cc + 1] && hs[rr][cc + 1] > max)
                max = hs[rr][cc + 1];
            hs[rr][cc] = max + 1;// 更新当前位置的最长滑雪路径
            // 顺便记录当前环境下的最长路径
            if (hs[rr][cc] > mm)
                mm = hs[rr][cc];
        }
        System.out.println(mm);
    }

    private static void run2() {
        Scanner cin = new Scanner(System.in);
        int r = cin.nextInt();// 行数
        int c = cin.nextInt();// 列数

        int[][] hs = new int[r][c];// 保留当前位置的最长滑雪路径
        int[][] hss = new int[r][c];// 保留当前位置的高度
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 和方法1不同,这里要初始化为1
                hs[i][j] = 1;
                int h = cin.nextInt();
                hss[i][j] = h;
            }
        }

        boolean finish;
        int i;
        int j;
        do {
            // 当finish为true时,表示所有位置的最长路径都没发生变化
            finish = true;
            // 从左上角到右下角
            for (i = 0; i < r; i++) {
                for (j = 0; j < c; j++) {
                    // 上边的高度比当前位置低,且左边的最长路径+1要大于当前位置的最长距离,这说明还有更好的路线
                    if (i - 1 >= 0 && hss[i - 1][j] < hss[i][j] && hs[i - 1][j] + 1 > hs[i][j]) {
                        hs[i][j] = hs[i - 1][j] + 1;
                        finish = false;
                    }
                    // 左边的高度比当前位置低,且左边的最长路径+1要大于当前位置的最长距离,这说明还有更好的路线
                    if (j - 1 >= 0 && hss[i][j - 1] < hss[i][j] && hs[i][j - 1] + 1 > hs[i][j]) {
                        hs[i][j] = hs[i][j - 1] + 1;
                        finish = false;
                    }
                }

            }

            // 从右下角到左上角
            for (i = r - 1; i >= 0; i--) {
                for (j = c - 1; j >= 0; j--) {
                    // 下边的高度比当前位置低,且左边的最长路径+1要大于当前位置的最长距离,这说明还有更好的路线
                    if (i + 1 < r && hss[i + 1][j] < hss[i][j] && hs[i + 1][j] + 1 > hs[i][j]) {
                        hs[i][j] = hs[i + 1][j] + 1;
                        finish = false;
                    }
                    // 右边的高度比当前位置低,且左边的最长路径+1要大于当前位置的最长距离,这说明还有更好的路线
                    if (j + 1 < c && hss[i][j + 1] < hss[i][j] && hs[i][j + 1] + 1 > hs[i][j]) {
                        hs[i][j] = hs[i][j + 1] + 1;
                        finish = false;
                    }
                }
            }
        } while (!finish);

        // 统计一下当前局面下的最长路径
        int mm = -1;
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                if (hs[i][j] > mm)
                    mm = hs[i][j];
            }
        }
        System.out.println(mm);
    }
}