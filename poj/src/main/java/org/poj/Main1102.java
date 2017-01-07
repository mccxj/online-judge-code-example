package org.poj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * LC-Display(http://poj.org/problem?id=1102)
 * <p/>
 * <p/>
 * 格式输出题目,需要细心
 */
public class Main1102 {
    private static final String s1 = "- -- -----";
    private static final String s2 = "|   ||| ||";
    private static final String s3 = "|||||  |||";
    private static final String s4 = "  ----- --";
    private static final String s5 = "| |   | | ";
    private static final String s6 = "|| |||||||";
    private static final String s7 = "- -- -- --";
    private static final String[] ss1 = {s1, s4, s7};
    private static final String[] ss2 = {s2, s3, s5, s6};

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String s;
        StringTokenizer token;
        while (!"0 0".equals(s = cin.nextLine())) {
            token = new StringTokenizer(s);
            int n = Integer.parseInt(token.nextToken());
            s = token.nextToken();

            // 整体分5行输出
            for (int i = 0; i < 5; i++) {
                // 只需要输出一行
                if (i % 2 == 0) {
                    for (int j = 0; j < s.length(); j++) {
                        char c = ss1[i / 2].charAt(s.charAt(j) - '0');

                        System.out.print(' ');
                        for (int t = 0; t < n; t++)
                            System.out.print(c);
                        System.out.print(' ');
                        if (j != s.length() - 1)
                            System.out.print(' ');
                    }
                    System.out.println();
                }
                // 需要输出n行
                else {
                    for (int t = 0; t < n; t++) {
                        for (int j = 0; j < s.length(); j++) {
                            char c1 = ss2[i - 1].charAt(s.charAt(j) - '0');
                            char c2 = ss2[i].charAt(s.charAt(j) - '0');
                            System.out.print(c1);
                            for (int tt = 0; tt < n; tt++)
                                System.out.print(' ');
                            System.out.print(c2);
                            if (j != s.length() - 1)
                                System.out.print(' ');
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }
    }
}
