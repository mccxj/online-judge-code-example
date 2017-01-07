package org.poj;

import java.util.Scanner;

/**
 * Message Decowding(http://poj.org/problem?id=2141)
 * <p/>
 * <p/>
 * 字符串操作题目,用数组存储即可
 */
public class Main2141 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        String key = cin.nextLine();
        String msg = cin.nextLine();

        int len = msg.length();
        int append = 'A' - 'a';
        for (int i = 0; i < len; i++) {
            char c = msg.charAt(i);
            if (c >= 'A' && c <= 'Z')
                System.out.print((char) (key.charAt(c - 'A') + append));
            else if (c >= 'a' && c <= 'z')
                System.out.print(key.charAt(c - 'a'));
            else
                System.out.print(c);
        }
        System.out.println();
    }
}