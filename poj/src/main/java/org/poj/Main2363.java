package org.poj;

import java.util.Scanner;

/**
 * Blocks(http://poj.org/problem?id=2363)
 * <p/>
 * <p/>
 * 堆砌多个一寸的正方体为长方体，要求长方体的表面积最小.使用穷举法,分隔成质数,然后合并得到三个最接近的数
 */
public class Main2363 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int tmp, a, b, c;// 代表三条边
        while (n-- > 0) {
            int num = cin.nextInt();
            int min = Integer.MAX_VALUE;
            int u = (int) (Math.pow(num, 1.0 / 3) + 1);
            int v = (int) (Math.sqrt(num) + 1);

            for (a = 1; a <= u; a++) {
                for (b = a; b <= v; b++) {
                    if (num % (a * b) == 0) {
                        c = num / (a * b);
                        tmp = (a * b + b * c + a * c) * 2;
                        if (tmp < min)
                            min = tmp;
                    }
                }
            }

            System.out.println(min);
        }
    }
}