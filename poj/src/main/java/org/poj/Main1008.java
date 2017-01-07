package org.poj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 玛雅历(http://poj.org/problem?id=1008)
 * <p/>
 * <p/>
 * 日历题,需要注意边界
 */
public class Main1008 {
    static String[] haab = {"pop", "no", "zip", "zotz", "tzec", "xul", "yoxkin", "mol", "chen", "yax", "zac", "ceh", "mac", "kankin", "muan", "pax", "koyab", "cumhu", "uayet"};
    static String[] holly = {"imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk", "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s;
        StringTokenizer token;
        int day, month, year;

        int n = Integer.parseInt(cin.nextLine());
        System.out.println(n);
        while (n-- > 0) {
            token = new StringTokenizer(cin.nextLine());
            s = token.nextToken();
            day = Integer.parseInt(s.substring(0, s.length() - 1));
            s = token.nextToken();
            month = -1;
            for (int i = 0; i < haab.length; i++)
                if (s.equals(haab[i]))
                    month = i;
            year = Integer.parseInt(token.nextToken());

            int days = year * 365 + month * 20 + day;
            year = days / 260;
            days = days % 260;
            month = days % 20;
            day = days % 13;

            System.out.printf("%d %s %d", day + 1, holly[month], year);
            System.out.println();
        }
    }
}