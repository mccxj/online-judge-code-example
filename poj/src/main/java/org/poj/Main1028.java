package org.poj;

import java.util.Scanner;

/**
 * Web Navigation(http://poj.org/problem?id=1028)
 * 
 * <p>
 * Accepted 3344K 1500MS Java 1244B 2013-04-09 21:30:23<br/>
 * 实现类似浏览器地址栏导航的功能,采用数组存储URL,使用两个索引:当前位置,最后有效位置
 */
public class Main1028 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int curr = 0;
        int top = 0;
        String[] urls = new String[101];
        urls[top] = "http://www.acm.org/";

        String cmd;
        while (!"QUIT".equals(cmd = cin.next())) {
            if ("VISIT".equals(cmd)) {
                String url = cin.next();
                curr++;
                top = curr;
                urls[curr] = url;
                System.out.println(url);
            } else if ("BACK".equals(cmd)) {
                if (curr == 0) {
                    System.out.println("Ignored");
                } else {
                    curr--;
                    System.out.println(urls[curr]);
                }
            } else if ("FORWARD".equals(cmd)) {
                if (curr == top) {
                    System.out.println("Ignored");
                } else {
                    curr++;
                    System.out.println(urls[curr]);
                }
            }
        }
    }
}