package org.poj;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 487-3279(http://poj.org/problem?id=1002)
 * 
 * <p>
 * 找到号码中的重复号码,思路是先进行排序再计算重复数
 */
public class Main1002 {
    public static void main(String args[]) {
        DecimalFormat f1 = new DecimalFormat("000");
        DecimalFormat f2 = new DecimalFormat("0000");

        Scanner cin = new Scanner(System.in);
        int len = cin.nextInt();

        int[] nums = new int[len + 1];
        nums[len] = 99999999;// 设置一个哨兵

        while (len-- > 0) {
            nums[len] = toNum(cin.next());
        }

        Arrays.sort(nums);

        // 判断是否有重复号码
        boolean hasDups = false;
        int p = nums[0];
        int dups = 1;
        for (int i = 1; i < nums.length; i++) {
            if (p == nums[i]) {
                dups++;
            } else {
                if (dups > 1) {
                    hasDups = true;
                    System.out.println(f1.format(p / 10000) + "-" + f2.format(p % 10000) + " " + dups);
                }
                dups = 1;
                p = nums[i];
            }
        }

        if (!hasDups) {
            System.out.println("No duplicates.");
        }
    }

    private static int toNum(String n) {
        int num = 0;
        // 每个电话号码由数字，大写字母（除了Q和Z）以及连接符组成。每个电话号码中只会刚好有7个数字或者字母
        for (char c : n.toCharArray()) {
            if (c == '-')
                continue;
            if (c >= 'A' && c <= 'P') {
                num = 10 * num + (c - 'A') / 3 + 2;
            } else if (c >= 'R' && c <= 'Y') {
                num = 10 * num + (c - 'Q') / 3 + 7;
            } else {
                num = 10 * num + c - '0';
            }
        }
        return num;
    }
}