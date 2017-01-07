package org.poj;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Moving Tables(http://poj.org/problem?id=1083)
 * 
 * <p>
 * 计算精确值
 */
public class Main1001 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String r = cin.next();
            int n = cin.nextInt();

            String dec = new BigDecimal(r).pow(n).toPlainString();
            int dot = dec.indexOf(".");

            char[] cs = dec.toCharArray();
            int len = cs.length;

            // 计算开始输出的位置
            int start = 0;
            if (dot != -1 && len > 1 && cs[0] == '0' && cs[1] == '.') {
                start = 1;
            }
            // 计算最后非0的位置
            int end = len - 1;
            if (dot != -1) {
                for (int i = len - 1; i >= start; i--) {
                    if (cs[i] != '0') {
                        end = i;
                        break;
                    }
                }
            }
            // 考虑只剩下一个.的情况
            if (start == end && cs[start] == '.')
                System.out.println("0");
            else {
                // 过滤整数的情况
                if (cs[end] == '.')
                    end--;
                for (int i = start; i <= end; i++) {
                    System.out.print(cs[i]);
                }
                System.out.println();
            }
        }
    }
}