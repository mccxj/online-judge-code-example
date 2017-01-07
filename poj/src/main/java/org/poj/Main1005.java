package org.poj;

import java.util.Scanner;

/**
 * I Think I Need a Houseboat(http://poj.org/problem?id=1005)
 * 
 * <p>
 * Accepted 3268K 172MS Java 919B 2013-04-07 22:14:18<br/>
 * 半圆表示一块面积可扩展的区域，开始时，面积是0，在（0,0）处开始以每年50平方米的速度同样呈半圆扩展，输入一个正整数N，然后输入N对坐标，
 * 对于每一对坐标值：求出面积扩展到该点的年数，坐标值单位为米。
 */
public class Main1005 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int len = cin.nextInt();
        for (int i = 1; i <= len; i++) {
            double x = cin.nextDouble();
            double y = cin.nextDouble();

            double res = (x * x + y * y) * Math.PI / 100;
            int year = (int) res;
            // 避免精度丢失
            if (res - year > 1e-6) {
                year++;
            }
            String msg = String.format("Property " + i + ": This property will begin eroding in year " + year + ".");
            System.out.println(msg);
        }
        System.out.println("END OF OUTPUT.");
    }
}