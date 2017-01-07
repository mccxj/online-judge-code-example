package org.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Integer Inquiry(http://poj.org/problem?id=1503)
 * 
 * <p>
 * 计算大整数的和
 */
public class Main1503 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String n;
        BigDecimal dec = new BigDecimal("0");
        while (!(n = cin.next()).equals("0")) {
            dec = dec.add(new BigDecimal(n));
        }
        System.out.println(dec.toPlainString());
    }
}