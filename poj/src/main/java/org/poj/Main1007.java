package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DNA Sorting(http://poj.org/problem?id=1007)
 * 
 * <p>
 * Accepted 3380K 1625MS Java 1281B 2013-04-08 23:21:47<br/>
 * Accepted 3380K 1579MS Java 1671B 2013-04-09 12:58:12<br/>
 * 对字符串的排序程度进行排列,类似计算反序对,这里直接用两次遍历就解决了,有点暴力.<br/>
 * 优化1:计算排序程度使用1次扫描过程<br/>
 * 优化2:把排序程度和原始序号合并存储,不使用复杂对象
 */
public class Main1007 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();// 每个字符串的长度
        int m = cin.nextInt();// 字符串数量

        String[] strs = new String[m];// 保存所有的字符串
        int[] cals = new int[m];// 保存所有的排序程度和原始序号
        for (int i = 0; i < m; i++) {
            String str = cin.next();
            strs[i] = str;
            // 对于最长50个字符的字符串来说，反序对最多就50*49/2，让它保留到低4位即可
            cals[i] = i + calsorts(str, n) * 1000;
        }

        Arrays.sort(cals);
        for (int i = 0; i < m; i++)
            System.out.println(strs[cals[i] % 1000]);
    }

    private static int calsorts(String str, int n) {
        int rev = 0;
        int csum = 0;
        int gsum = 0;
        int tsum = 0;

        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            switch (c) {
            case 'A':
                rev += csum + gsum + tsum;
                break;
            case 'C':
                csum++;
                rev += gsum + tsum;
                break;
            case 'G':
                gsum++;
                rev += tsum;
                break;
            case 'T':
                tsum++;
                break;
            default:
                break;
            }
        }
        return rev;
    }
}