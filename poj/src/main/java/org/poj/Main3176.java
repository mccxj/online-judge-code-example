package org.poj;

import java.util.Scanner;

/**
 * Cow Bowling(http://poj.org/problem?id=3176)
 * <p/>
 * <p/>
 * 和1163是一样的题目
 */
public class Main3176 {
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