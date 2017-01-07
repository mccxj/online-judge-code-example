package org.poj;

import java.util.Scanner;

/**
 * Clay Bully(http://poj.org/problem?id=1547)
 * <p/>
 * <p/>
 * 简单题,不解释
 */
public class Main1547 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        while ((n = cin.nextInt()) != -1) {
            int[] block = new int[n];
            String[] child = new String[n];
            int min = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                block[i] = cin.nextInt() * cin.nextInt() * cin.nextInt();
                child[i] = cin.next();

                if (block[i] <= block[min])
                    min = i;
                if (block[i] >= block[max])
                    max = i;
            }
            System.out.println(child[max] + " took clay from " + child[min] + ".");
        }
    }
}