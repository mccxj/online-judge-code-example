package org.poj;

import java.util.Scanner;

/**
 * All in All(http://poj.org/problem?id=1936)
 * 
 * <p>
 * 判断某个字符串是否是另外一个字符串的子串<br/>
 * 比较简单,对第一个字符串从头到尾扫描,对每个字符扫描在第二个字符串最近出现的位置,下一个字符就从这个位置继续扫描.判断所有字符是否都能找到.
 */
public class Main1936 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        while (cin.hasNext()) {
            String s = cin.next();
            String t = cin.next();

            boolean found = true;
            int len = s.length();
            int lastIdx = -1;
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                lastIdx = t.indexOf(c, lastIdx + 1);
                if (lastIdx == -1) {
                    found = false;
                    break;
                }
            }
            System.out.println(found ? "Yes" : "No");
        }
    }
}