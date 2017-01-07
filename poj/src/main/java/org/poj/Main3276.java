package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Face The Right Way(http://poj.org/problem?id=3276)
 * <p/>
 * <p/>
 * 牛转身,让pos[i]表示第i个位置和第j个位置的牛的方向是否一样,反转的时候就可以简化逻辑
 */
public class Main3276 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        //cows[i]为1表示B,为0表示F
        int[] cows = new int[n];
        // pos[i]为0表示和前一个方向相同,为1表示相反
        int[] pos = new int[n];

        int mink = 1;// 能够实现最小反转次数的最小操作个数K
        int minm = 0;//记录最小反转次数M
        for (int i = 0; i < n; i++) {
            if ("F".equals(reader.readLine())) {
                cows[i] = 0;
            } else {
                cows[i] = 1;
                minm++;//反转1个的情况
            }
        }

        // 初始化方向
        pos[0] = cows[0];
        for (int i = 1; i < n; i++)
            pos[i] = cows[i] == cows[i - 1] ? 0 : 1;

        // 我不知怎么证明最多只需验证max个的情况
        int max = minm;
        // 穷举,从反转2个开始直到n个的情况
        for (int j = 2; j <= max; j++) {
            // 构建一个新的状态
            int[] npos = new int[n];
            System.arraycopy(pos, 0, npos, 0, n);

            int sum = 0;
            // 从头开始,如果当前位置和前一个不同,则进行反转
            for (int i = 0; i < n - j + 1; i++) {
                if (npos[i] == 1) {
                    sum++;
                    if (sum >= minm)
                        break;
                    //关键,反转第一个的相对方向和最后一个的下一个的相对方向
                    npos[i] = 1 - npos[i];
                    if (i + j < n)
                        npos[i + j] = 1 - npos[i + j];
                }
            }

            // 判断最终状态是否满足要求
            if (sum < minm) {
                boolean ok = true;
                for (int k = n - j + 1; k < n; k++) {
                    if (npos[k] == 1) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    minm = sum;
                    mink = j;
                }
            }
        }

        System.out.println(mink + " " + minm);
    }
}