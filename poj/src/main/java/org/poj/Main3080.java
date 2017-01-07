package org.poj;

import java.util.Scanner;

/**
 * Blue Jeans(http://poj.org/problem?id=3080)
 * 
 * <p>
 * 找到最长的连续子串,暴力查找
 */
public class Main3080 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            int m = cin.nextInt();
            String[] strs = new String[m];
            for (int i = 0; i < m; i++) {
                strs[i] = cin.next();
            }

            String max = "";
            for (int i = 0; i < 58; i++) {
                int len = max.length();
                for (int j = 60; j >= i + 3 && j >= i + len; j--) {
                    String subs = strs[0].substring(i, j);
                    boolean found = true;
                    for (int k = 1; k < m; k++) {
                        if (!strs[k].contains(subs)) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        // 找到更长的字符串或更靠前的字符串
                        if (len < j - i || (len == j - i && 0 > subs.compareTo(max))) {
                            max = subs;
                        }
                        break;
                    }
                }
            }

            if (max.isEmpty())
                System.out.println("no significant commonalities");
            else
                System.out.println(max);
        }
    }
}