package org.poj;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Surprising Strings(http://poj.org/problem?id=3096)
 * <p/>
 * <p/>
 * 字符串匹配,用set来判断重复
 */
public class Main3096 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        String str;
        while (!(str = cin.nextLine()).startsWith("*")) {
            int len = str.length();

            boolean ok = true;
            for (int i = 0; i < len - 2; i++) {// i表示D-pairs中的D
                Set<Integer> s = new TreeSet<Integer>();
                for (int j = 0; j < len - i - 1; j++) {// j表示当前处理的位置
                    int t = (int) str.charAt(j) * 100 + (int) str.charAt(j + i + 1);
                    if (s.contains(t)) {
                        ok = false;
                        break;
                    } else {
                        s.add(t);
                    }
                }

                if (!ok) {
                    break;
                }
            }

            if (ok)
                System.out.println(str + " is surprising.");
            else
                System.out.println(str + " is NOT surprising.");
        }
    }
}