package org.poj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Snowflake Snow Snowflakes(http://poj.org/problem?id=3349)
 * 
 * <p>
 * 判断是否存在同形的雪花<br/>
 * 因为可以正向或者反向,所以拼接多一段,例如1 2 3 4 5 6,其实就是<br/>
 * 正向: 1 2 3 4 5 6 1 2 3 4 5 6 <br/>
 * 反向: 6 5 4 3 2 1 6 5 4 3 2 1 <br/>
 * 对于另一个雪花4 3 2 1 6 5,查找是否在上述两个字符串里边即可<br/>
 * 
 * 不过结果是Time Limit Exceeded<br/>
 * 采用自定义的数据结构,如Hash、List可以减少内存使用.<br/>
 * 这里有个主要的问题是,对于大数据输入的情况,使用Scanner不行,需要使用BufferedReader
 */
class Node {
    int index;
    Node next;
}

public class Main3349 {
    private static final int HASH = 99971;

    public static void main(String args[]) throws Exception {
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(cin.readLine());// 雪花数量
        Node[] snows = new Node[HASH];
        StringTokenizer st;
        int[][] vals = new int[n][6];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(cin.readLine());
            for (int j = 0; j < 6; j++) {
                vals[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            int[] val = vals[i];

            // 计算hash值
            int hash = (val[0] + val[1] + val[2] + val[3] + val[4] + val[5]) % HASH;
            // 添加到Hash中
            if (snows[hash] != null) {
                Node v = snows[hash];
                // 逐个匹配是否在正向或反向表示的字符串中出现
                while (v != null) {
                    if (isSame(vals[v.index], val)) {
                        System.out.println("Twin snowflakes found.");
                        return;
                    }
                    if (v.next != null) {
                        v = v.next;
                    } else {
                        Node t = new Node();
                        t.index = i;
                        v.next = t;
                        v = null;
                    }
                }
            } else {
                Node t = new Node();
                t.index = i;
                snows[hash] = t;
            }
        }
        System.out.println("No two snowflakes are alike.");
    }

    private static boolean isSame(int[] vs, int[] val) {
        for (int i = 0; i < 6; i++) {
            if (/* 顺时针方向 */
            (vs[0] == val[i]
             && vs[1] == val[(i + 1) % 6]
             && vs[2] == val[(i + 2) % 6]
             && vs[3] == val[(i + 3) % 6]
             && vs[4] == val[(i + 4) % 6] && vs[5] == val[(i + 5) % 6])
                    ||
                    /* 逆时针方向 */
                    (vs[0] == val[i]
                     && vs[1] == val[(i + 5) % 6]
                     && vs[2] == val[(i + 4) % 6]
                     && vs[3] == val[(i + 3) % 6]
                     && vs[4] == val[(i + 2) % 6] && vs[5] == val[(i + 1) % 6]))
                return true;
        }
        return false;
    }
}