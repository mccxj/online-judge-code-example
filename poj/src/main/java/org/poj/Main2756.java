package org.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Autumn is a Genius(http://poj.org/problem?id=2756)
 * <p/>
 * <p/>
 * 高精度题目,类似A+B
 */
public class Main2756 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        while (n-- > 0) {
            BigDecimal a = cin.nextBigDecimal();
            BigDecimal b = cin.nextBigDecimal();
            System.out.println(a.add(b).toPlainString());
        }
    }
}