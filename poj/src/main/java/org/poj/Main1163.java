package org.poj;

import java.util.Scanner;

/**
 * The Triangle(http://poj.org/problem?id=1163)
 * <p/>
 * <p/>
 * DP题,求从顶点到叶子的和最大的路径 这里采用自顶向下的计算方法,设置nums[i][j]表示从顶点到i行j列的和的最大值,
 * 则有 nums[i][j] = max{nums[i-1][j-1], nums[i-1][j]} + t[i][j]
 * 使用滚动数组的话,得到nums[j] = max{nums[j-1], nums[j]} + t
 * 同样,也可以采用自底向上的方式
 */
public class Main1163 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] nums = new int[n + 1];

        nums[1] = cin.nextInt();
        for (int i = 2; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                nums[j] = Math.max(nums[j - 1], nums[j]) + cin.nextInt();
            }
        }

        int max = nums[1];
        for (int i = 1; i <= n; i++)
            if (max < nums[i])
                max = nums[i];
        System.out.println(max);
    }
}