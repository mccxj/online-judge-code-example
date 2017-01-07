package org.poj;

import java.util.Scanner;

/**
 * 0/1背包变种
 */
public class Main1014 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int[] num = new int[6];
        int seq = 1;
        while (true) {
            int curr = 0;
            int[] nums = new int[100];
            int[] box = new int[100];
            int sum = 0;
            for (int i = 0; i < 6; i++) {
                num[i] = cin.nextInt();
                sum += (i + 1) * num[i];
                int t = num[i];
                int k = 1;
                // 进行二进制优化
                while (t >= k) {
                    box[curr] = i + 1;
                    nums[curr++] = k;
                    t -= k;
                    k *= 2;
                }
                if (t > 0) {
                    nums[curr] = t;
                    box[curr++] = i + 1;
                }
            }
            if (num[0] == 0 && num[1] == 0 && num[2] == 0 && num[3] == 0 && num[4] == 0 && num[5] == 0)
                break;

            System.out.println("Collection #" + (seq++) + ":");
            // 奇数的话,肯定是没法切割的
            if (sum % 2 != 0) {
                System.out.println("Can't be divided.");
                System.out.println();
                continue;
            }

            // m[i][j]表示用前面i个组合合并的最接近j的最大值
            int half = sum / 2;
            int[] m = new int[half + 1];
            for (int i = 1; i <= curr; i++) {
                for (int j = half; j >= 1; j--) {
                    int tmp = nums[i - 1] * box[i - 1];
                    if (j >= tmp) {
                        m[j] = Math.max(m[j], m[j - tmp] + tmp);
                    }
                }
            }

            System.out.println(m[half] == half ? "Can be divided." : "Can't be divided.");
            System.out.println();
        }
    }
}