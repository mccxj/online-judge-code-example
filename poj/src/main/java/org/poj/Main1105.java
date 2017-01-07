package org.poj;

import java.util.Scanner;

/**
 * S-Trees(http://poj.org/problem?id=1105)
 * <p/>
 * <p/>
 * 每个VVA的位置相当于化成10进制之后的位置
 */
public class Main1105 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        // 使用char节约点内存,用int更容易理解点
        char[] pos = new char[7];
        char[] tmp = new char[7];
        int n;
        int k = 1;
        while ((n = cin.nextInt()) != 0) {
            for (int i = 0; i < n; i++) {
                char[] c = cin.next().toCharArray();
                // 记录输出顺序,pos前n个位置是有效的
                pos[c[1] - '1'] = (char) i;
            }
            char[] bits = cin.next().toCharArray();

            System.out.printf("S-Tree #%d:\n", k++);
            int m = cin.nextInt();
            while (m-- > 0) {
                char[] c = cin.next().toCharArray();
                // 调整顺序为X1~Xk
                for (int i = 0; i < n; i++) {
                    tmp[pos[i]] = (char) (c[i] - '0');
                }
                int res = 0;
                // 计算二进制为十进制
                for (int i = 0; i < n; i++) {
                    res <<= 1;
                    if (tmp[i] != 0)
                        res++;
                }
                System.out.print(bits[res]);
            }

            System.out.println();
            System.out.println();
        }
    }
}