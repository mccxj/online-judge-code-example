package org.poj;

import java.util.Scanner;

/**
 * SPIN(http://poj.org/problem?id=2316)
 * <p/>
 * <p/>
 * 箱子密码,简单的无进位加法运算
 */
public class Main2316 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        char[] pass = cin.nextLine().toCharArray();
        int len = pass.length;
        while (cin.hasNext()) {
            char[] oper = cin.nextLine().toCharArray();
            for (int i = 0; i < len; i++) {
                pass[i] = (char) ('0' + ((pass[i] - '0') + (oper[i] - '0')) % 10);
            }
        }
        System.out.println(pass);
    }
}