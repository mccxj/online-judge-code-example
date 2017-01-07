package org.poj;

import java.util.Scanner;
import java.util.Stack;

/**
 * 找到最少多少栋楼可以覆盖,前后两个角如果高度一样并且中间只有更高的就可以合并,使用栈来比较
 */
public class Main3044 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextInt();

        Stack<Integer> u = new Stack<Integer>();
        Stack<Integer> v = new Stack<Integer>();
        for (int i = 0; i < n; i++) {
            cin.nextInt();
            int y = cin.nextInt();

            while (!u.isEmpty()) {
                int k = u.pop();
                if (k != y)
                    v.push(k);
                if (k <= y)
                    break;
            }

            while (!v.isEmpty()) {
                u.push(v.pop());
            }
            u.push(y);
        }

        int min = 0;
        while (!u.isEmpty()) {
            if (0 != u.pop())
                min++;
        }
        System.out.println(min);
    }
}