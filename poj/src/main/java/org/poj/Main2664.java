package org.poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Prerequisites?(http://poj.org/problem?id=2664)
 * <p/>
 * 超级简单题,没什么好解释的
 */
public class Main2664 {
    public static void main(String args[]) {
        int k, m, c, r;
        Scanner cin = new Scanner(System.in);

        while ((k = cin.nextInt()) != 0) {
            m = cin.nextInt();
            Set<String> course = new HashSet<String>();
            while (k-- > 0)
                course.add(cin.next());

            String meet = "yes";
            while (m-- > 0) {
                c = cin.nextInt();
                r = cin.nextInt();
                while (c-- > 0) {
                    if (course.contains(cin.next())) {
                        r--;
                    }
                }
                if (r > 0)
                    meet = "no";
            }
            System.out.println(meet);
        }
    }
}