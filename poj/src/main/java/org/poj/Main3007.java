package org.poj;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Organize Your Train part II(http://poj.org/problem?id=3007)
 * <p/>
 * <p/>
 * 字符串匹配,用set来保存,判断重复
 */
public class Main3007 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();

        while (n-- > 0) {
            String str = cin.next();
            int len = str.length();

            // 得到反转的字符串
            StringBuilder sb = new StringBuilder(len);
            for (int i = len - 1; i >= 0; i--)
                sb.append(str.charAt(i));
            String restr = sb.toString();

            Set<String> s = new TreeSet<String>();
            // 添加完整和反转的,后面分隔的时候排除这两种情况
            s.add(str);// 1正2正
            s.add(restr);// 2反1反

            for (int i = 1; i < len; i++) {// i表示切割的第一部分的长度
                String s1 = str.substring(0, i);// 第一部分正向
                String s2 = str.substring(i);// 第二部分正向
                String re1 = restr.substring(len - i);// 第一部分反向
                String re2 = restr.substring(0, len - i);// 第二部分反向

                s.add(s1 + re2);// 1正2反
                s.add(re1 + s2);// 1反2正
                s.add(re1 + re2);// 1反2反
                s.add(s2 + s1);// 2正1正
                s.add(s2 + re1);// 2正1反
                s.add(re2 + s1);// 2反1正
            }
            System.out.println(s.size());
        }
    }
}