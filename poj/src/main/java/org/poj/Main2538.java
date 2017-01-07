package org.poj;

import java.util.Scanner;

/**
 * WERTYU(http://poj.org/problem?id=2538)
 * <p/>
 * <p/>
 * 简单题目,用数组映射一下即可
 */
public class Main2538 {
    private static final String origin = "`1234567890-QWERTYUIOP[]ASDFGHJKL;ZXCVBNM,.";
    private static final String input = "1234567890-=WERTYUIOP[]\\SDFGHJKL;'XCVBNM,./";

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            char[] cs = cin.nextLine().toCharArray();
            for (int i = 0; i < cs.length; i++) {
                int idx = input.indexOf(cs[i]);
                if (idx != -1)
                    cs[i] = origin.charAt(idx);
            }
            System.out.println(cs);
        }
    }
}