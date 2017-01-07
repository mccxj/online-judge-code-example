package org.poj;

import java.util.Scanner;

/**
 * Spell checker(http://poj.org/problem?id=1035)
 * 
 * <p>
 * 找到单词或者相似的单词<br/>
 * 用数组记录单词和它的长度,对于输入的单词,根据长度判断'长度相同','短一位','长一位'三种情况进行判断.<br/>
 * 当然,如果对长度先进行排序的话,可以更快的找到相应的长度的单词.
 */
public class Main1035 {
    private static final int MAX = 10000;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int cur = 0;
        String[] strs = new String[MAX];
        int[] lens = new int[MAX];
        String cmd;
        // 初始化字典
        while (!(cmd = cin.next()).startsWith("#")) {
            strs[cur] = cmd;
            lens[cur++] = cmd.length();
        }

        int i, j, k;
        // 判断单词
        while (!(cmd = cin.next()).startsWith("#")) {
            int len = cmd.length();
            boolean equal = false;
            int ai = 0;// 记录类似单词的个数
            int[] almost = new int[50];// 记录类似的单词

            for (i = 0; i < cur; i++) {
                if (lens[i] == len) {// 长度相同
                    String str = strs[i];
                    int max = 0;// 最大不同的字符,为1表示类似,为0表示相同
                    for (j = 0; j < len; j++) {
                        if (str.charAt(j) != cmd.charAt(j)) {
                            max++;
                        }
                    }

                    if (max == 0) {
                        equal = true;
                        break;
                    } else if (max == 1)
                        almost[ai++] = i;
                } else if (lens[i] == len - 1) {// 比输入单词较短
                    String str = strs[i];
                    for (j = 0, k = 0; j < len - 1 && k < len;) {
                        if (str.charAt(j) == cmd.charAt(k)) {
                            j++;
                        }
                        k++;
                    }
                    // 位置有差异1位或最后一位有差异
                    if (j == k - 1 || (j == k && k == len - 1))
                        almost[ai++] = i;
                } else if (lens[i] == len + 1) {// 比输入单词较长
                    String str = strs[i];
                    for (j = 0, k = 0; j < len && k < len + 1;) {
                        if (cmd.charAt(j) == str.charAt(k)) {
                            j++;
                        }
                        k++;
                    }
                    // 位置有差异1位或最后一位有差异
                    if (j == k - 1 || (j == k && k == len))
                        almost[ai++] = i;
                }
            }

            if (equal) {
                System.out.println(cmd + " is correct");
            } else {
                System.out.print(cmd);
                System.out.print(":");
                for (i = 0; i < ai; i++) {
                    System.out.print(" ");
                    System.out.print(strs[almost[i]]);
                }
                System.out.println();
            }
        }
    }
}
