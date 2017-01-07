package org.poj;

import java.util.Scanner;

/**
 * The Hardest Problem Ever(http://poj.org/problem?id=1298)
 * <p/>
 * <p/>
 * 字符操作题,使用简单的位移
 */
public class Main1298 {
    public static void main(String[] args) {
        String line, s;
        Scanner cin = new Scanner(System.in);
        while (!"ENDOFINPUT".equals(line = cin.nextLine())) {
            if ("START".equals(line)) {
                while (!"END".equals(s = cin.nextLine())) {
                    int len = s.length();
                    StringBuilder sb = new StringBuilder(len);
                    for (int i = 0; i < len; i++) {
                        char c = s.charAt(i);
                        if (c >= 'A' && c <= 'Z')
                            c = (char) ('A' + (c - 'A' + 21) % 26);
                        sb.append(c);
                    }
                    System.out.println(sb);
                }
            }
        }
    }
}