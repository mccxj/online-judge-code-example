package org.poj;

import java.util.Scanner;

/**
 * Flip Game(http://poj.org/problem?id=1753)
 * 
 * <p>
 * Accepted 2988K 3188MS Java 2218B 2013-04-16 22:01:07<br/>
 * 翻转棋子,使用16位来表示当前状态,并枚举所有的操作方式(也用位表示,范围是0~2^16-1)
 */
public class Main1753 {
    // 对于某个位置的翻转,缓存相应的位操作
    private static final int[] xors = {0xc800,
                                       0xe400,
                                       0x7200,
                                       0x3100,
                                       0x8c80,
                                       0x4e40,
                                       0x2720,
                                       0x1310,
                                       0x08c8,
                                       0x04e4,
                                       0x0272,
                                       0x0131,
                                       0x008c,
                                       0x004e,
                                       0x0027,
                                       0x0013};

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        // 当前状态(从左上到右下,代表第0~15位),16位中的0表示b,1表示w
        int curr = 0;
        for (int i = 0; i < 4; i++) {
            char[] cs = cin.next().toCharArray();
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == 'w') {
                    // 把该位设置为1
                    curr |= (1 << (15 - i * 4 - j));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        // 范围是0~2^16-1
        for (int i = 0; i < 65536; i++) {
            // 对每个状态进行匹配curr,看是否得到结果
            int tmp = curr;
            // 遍历16个位,如果是1的话,对当前状态进行处理
            int bs = 0;// 计算为1的数量
            for (int j = 0; j < 16; j++) {
                if ((i & (1 << j)) != 0) {
                    bs++;
                    // 上下左右对应的位是j-4,j+4,j-1,j+1,对相应的位进行翻转
                    tmp ^= xors[j];
                }
            }
            // 全b或全w的话,表示匹配到
            if ((tmp == 0xFFFF || tmp == 0x0000) && bs < min)
                min = bs;
        }

        if (min == Integer.MAX_VALUE)
            System.out.println("Impossible");
        else
            System.out.println(min);
    }
}