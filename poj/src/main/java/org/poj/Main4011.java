package org.poj;

import java.io.IOException;
import java.util.Scanner;

/**
 * 枚举超级水题
 */
public class Main4011 {
    public static void main(String args[]) throws IOException {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int lucky = 0;
        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (n - i - j == 0)
                    lucky++;
        System.out.println(lucky);
    }
}