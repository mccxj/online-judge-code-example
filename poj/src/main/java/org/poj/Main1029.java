package org.poj;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * False coin(http://poj.org/problem?id=1029)
 * <p/>
 * <p/>
 * 模拟题目,和poj1013思路类似,即使无法判断是轻是重,但能判断出是哪个就可以了
 */
public class Main1029 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        StringTokenizer token = new StringTokenizer(cin.nextLine());
        int n = Integer.parseInt(token.nextToken());//个数
        int k = Integer.parseInt(token.nextToken());//测试次数

        // 初始化所有测试
        Object[][] cmds = new Object[k][];
        for (int i = 0; i < k; i++) {
            token = new StringTokenizer(cin.nextLine());
            int len = Integer.parseInt(token.nextToken());
            int[] left = new int[len];
            int[] right = new int[len];
            for (int j = 0; j < len; j++)
                left[j] = Integer.parseInt(token.nextToken());
            for (int j = 0; j < len; j++)
                right[j] = Integer.parseInt(token.nextToken());
            cmds[i] = new Object[]{cin.nextLine(), left, right};
        }

        // 0为正常,1为偏重,-1为偏轻
        int[] coins = new int[n + 1];
        // 可能的情况个数,当个数为1时,得到结果
        int pass = 0;
        int falsecoin = -1;
        for (int i = 0; i < 2 * n; i++) {
            int t = i % 2 == 0 ? 1 : -1;
            int idx = i / 2 + 1;
            coins[idx] = t;

            boolean ok = true;
            for (Object[] cmd : cmds) {
                int sumleft = 0;
                for (int l : (int[]) cmd[1])
                    sumleft += coins[l];
                int sumright = 0;
                for (int l : (int[]) cmd[2])
                    sumright += coins[l];

                if ("<".equals(cmd[0])) {
                    if (sumleft >= sumright) {
                        ok = false;
                        break;
                    }
                } else if (">".equals(cmd[0])) {
                    if (sumleft <= sumright) {
                        ok = false;
                        break;
                    }
                } else if ("=".equals(cmd[0])) {
                    if (sumleft != sumright) {
                        ok = false;
                        break;
                    }
                }
            }

            // 即使无法判断是轻是重,但能判断出是哪个就可以了
            if (ok && falsecoin != idx) {
                falsecoin = idx;
                pass++;
            }
            coins[idx] = 0;// 恢复
        }

        System.out.println(pass == 1 ? falsecoin : 0);
    }
}