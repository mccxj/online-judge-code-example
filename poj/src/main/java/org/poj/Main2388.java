package org.poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Who's in the Middle(http://poj.org/problem?id=2388)
 * 
 * <p>
 * 判断中位数,使用计数法<br/>
 */
public class Main2388 {
    private static final int MAX = 1000001;

    public static void main(String args[]) throws Exception {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in), 8192);
        int n = Integer.parseInt(cin.readLine());// 奶牛数量

        int[] bs = new int[MAX];
        for (int i = 0; i < n; i++) {
            bs[Integer.parseInt(cin.readLine())]++;
        }
        int mid = (n >> 1) + 1;
        for (int i = 0; i < MAX; i++) {
            mid -= bs[i];
            if (mid <= 0) {
                System.out.println(i);
                return;
            }
        }
    }
}