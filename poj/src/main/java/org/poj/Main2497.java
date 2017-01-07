package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Strategies(http://poj.org/problem?id=2497)
 * <p/>
 * <p/>
 * 数学题,只要仔细想想就知道Steve的策略永远都是最优,必定是第一名,只需要计算他的解题分数即可
 */
public class Main2497 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int contest, problem, n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            contest = cin.nextInt();//比赛的时长
            problem = cin.nextInt();//比赛的题目数量
            int[] times = new int[problem];
            for (int j = 0; j < problem; j++)
                times[j] = cin.nextInt();
            Arrays.sort(times);

            int slove = 0;
            int score = 0;
            int time = 0;
            while (slove < problem && time + times[slove] <= contest) {
                time += times[slove++];
                score += time;
            }
            System.out.println("Scenario #" + (i + 1) + ":");
            System.out.println("Steve wins with " + slove + " solved problems and a score of " + score + ".");
            System.out.println();
        }
    }
}