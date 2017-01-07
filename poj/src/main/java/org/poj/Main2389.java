package org.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Bull Math(http://poj.org/problem?id=2389)
 * <p/>
 * <p/>
 * 高精度题目,类似A+B
 */
public class Main2389 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        BigDecimal a = cin.nextBigDecimal();
        BigDecimal b = cin.nextBigDecimal();
        System.out.println(a.multiply(b).toPlainString());
    }
}