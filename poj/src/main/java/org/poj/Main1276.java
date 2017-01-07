package org.poj;

import java.util.Scanner;

/**
 * Cash Machine(http://poj.org/problem?id=1276)
 * <p/>
 * <p/>
 * 银行钞票机器,对于每种钞票有一个最大数量限制,求能给出的最接近的钞票值
 * 没有使用滚动数组的话,会出现Memory Limit Exceeded
 * 没有使用二进制优化的话(见背包九讲),会出现Time Limit Exceeded
 */
public class Main1276 {
    private static final int MAX_TYPE = 100;

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int cash = cin.nextInt();//希望得到的钞票值
            int type = cin.nextInt();//钞票种类

            int[] bills = new int[MAX_TYPE];//最大钞票数量
            int[] as = new int[MAX_TYPE];//钞票面额
            int bsl = 0;//二进制优化后的总数量
            for (int i = 0; i < type; i++) {
                int bt = cin.nextInt();
                int ast = cin.nextInt();
                int k = 1;
                //对背包对象进行二进制优化,转换成0/1背包
                while (bt >= k) {
                    bills[bsl] = k;
                    as[bsl++] = ast;
                    bt -= k;
                    k *= 2;
                }
                if (bt > 0) {
                    bills[bsl] = bt;
                    as[bsl++] = ast;
                }
            }

            //v[i,j]表示使用1~i中的面额,得到不超过j的最大钞票值
            //v[i,j] = max{v[i-1,j], v[i-1,j-k*as[i]]+k*as[i]} k<=bills[i],j>=k*as[i]
            //需要进行二进制优化,不然会超时
            int[] v = new int[cash + 1];
            for (int i = 0; i < bsl; i++) {
                for (int j = cash; j >= 0; j--) {
                    int tmp = bills[i] * as[i];
                    if (j >= tmp) {
                        int t = v[j - tmp] + tmp;
                        if (v[j] < t) {
                            v[j] = t;
                        }
                    }
                }
            }
            System.out.println(v[cash]);
        }
    }
}