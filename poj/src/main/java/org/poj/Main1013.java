package org.poj;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Counterfeit Dollar(http://poj.org/problem?id=1013)
 * 
 * <p>
 * 找出假币,采用穷举法,猜哪个是假币,去匹配是否符合给出的条件
 */
public class Main1013 {
    private static final int COINLEN = 12;
    private static final int CMDLEN = 3;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();

        // -1偏轻 0正常 1偏重
        int[] states = new int[COINLEN];
        while (num-- > 0) {
            String[][] cmds = new String[CMDLEN][CMDLEN];
            for (int i = 0; i < CMDLEN; i++) {
                cmds[i] = new String[]{cin.next(), cin.next(), cin.next()};
            }

            for (int t = 0; t < COINLEN * 2; t++) {
                Arrays.fill(states, 0); // 重置
                states[t / 2] = t % 2 == 0 ? -1 : 1;
                boolean valid = true;
                for (int i = 0; i < CMDLEN; i++) {

                    // 左边-右边
                    int sum = 0;
                    for (char c : cmds[i][0].toCharArray()) {
                        sum += states[c - 'A'];
                    }
                    for (char c : cmds[i][1].toCharArray()) {
                        sum -= states[c - 'A'];
                    }

                    String res = cmds[i][2];
                    if ("even".equals(res) && sum != 0) {
                        valid = false;
                        break;
                    } else if ("down".equals(res) && sum >= 0) {
                        valid = false;
                        break;
                    } else if ("up".equals(res) && sum <= 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    String m = t % 2 == 0 ? "light" : "heavy";
                    String msg = Character.toString((char) ('A' + t / 2)) + " is the counterfeit coin and it is " + m + ".";
                    System.out.println(msg);
                    break;
                }
            }
        }
    }
}