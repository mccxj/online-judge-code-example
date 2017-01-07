package org.poj;

import java.util.Scanner;

/**
 * Vertical Histogram(http://poj.org/problem?id=2136)
 * <p/>
 * <p/>
 * 统计字符个数并输出,简单题,注意输出
 */
public class Main2136 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int lines = 4;
        int[] cs = new int[26];
        while (lines-- > 0) {
            for (char c : cin.nextLine().toCharArray()) {
                if (c >= 'A' && c <= 'Z')
                    cs[c - 'A']++;
            }
        }

        while (true) {
            // 获取当前行的最后的输出位置
            int pos = -1;
            int max = 1;
            for (int i = 0; i < 26; i++)
                if (max <= cs[i]) {
                    max = cs[i];
                    pos = i;
                }

            if (pos == -1)
                break;

            for (int i = 0; i <= pos; i++) {
                if (cs[i] >= max) {
                    cs[i]--;
                    System.out.print("*");
                } else
                    System.out.print(" ");
                if (i != pos)
                    System.out.print(" ");
            }
            System.out.println();
        }

        // 最后一行
        System.out.println("A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
    }
}