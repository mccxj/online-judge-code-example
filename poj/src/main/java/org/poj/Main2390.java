package org.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Bank Interest(http://poj.org/problem?id=2390)
 * <p/>
 * <p/>
 * 简单数学题,注意高精度
 */
public class Main2390 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        BigDecimal r = new BigDecimal(100 + cin.nextInt()).divide(new BigDecimal(100.0));// 利息率
        BigDecimal m = cin.nextBigDecimal();// 本金
        int y = cin.nextInt();// 年数

        while (y-- > 0) {
            m = m.multiply(r);
        }

        System.out.println(m.longValue());
    }
}