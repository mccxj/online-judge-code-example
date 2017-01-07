package org.poj;

import java.util.Scanner;

/**
 * Anagram(http://poj.org/problem?id=1256)
 * <p/>
 * <p/>
 * 全排列,使用递归
 */
public class Main1256 {
    static boolean[] visit;
    static char[] cs;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int n = Integer.parseInt(cin.nextLine());
        while (n-- > 0) {
            cs = cin.nextLine().toCharArray();
            int len = cs.length;
            visit = new boolean[len];

            // 排序
            for (int i = 0; i < len - 1; i++) {
                for (int j = i + 1; j < len; j++) {
                    char ci = Character.toLowerCase(cs[i]);
                    char cj = Character.toLowerCase(cs[j]);
                    if (ci > cj || (ci == cj && cs[i] > cs[j])) {
                        char t = cs[i];
                        cs[i] = cs[j];
                        cs[j] = t;
                    }
                }
            }

            char[] newcs = new char[len];
            bfs(newcs, 0);
        }
    }

    private static void bfs(char[] newcs, int curr) {
        if (curr == cs.length) {
            System.out.println(String.valueOf(newcs));
            return;
        }

        char t = '0';
        for (int i = 0; i < cs.length; i++) {
            if (!visit[i] && cs[i] != t) {
                t = cs[i];
                visit[i] = true;
                newcs[curr] = cs[i];
                bfs(newcs, curr + 1);
                visit[i] = false;
            }
        }
    }
}