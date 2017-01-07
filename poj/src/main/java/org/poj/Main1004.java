package org.poj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Financial Management(http://poj.org/problem?id=1004)
 * 
 * <p>
 * Accepted 3172K 110MS Java 510B 2013-04-07 21:18:38<br/>
 * 计算账户十二个月的平均余额
 */
public class Main1004 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        double sum = 0.0d;
        for (int i = 0; i < 12; i++) {
            sum += cin.nextDouble();
        }

        System.out.print("$");
        System.out.print(new DecimalFormat("#.##").format(sum / 12));
    }
}