package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Sticks(http://poj.org/problem?id=1011)
 * <p/>
 * <p/>
 * 木棍,使用递归思路,需要做一下裁剪,例如当当前是left的第一根或最后一根,说明已经没办法继续处理了
 */
public class Main1011 {
    static short[] wood = new short[64];
    static char[] visit = new char[64];// 用来记录已经被选择过的木棍

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i, n, k, len, sum;
        StringTokenizer token;
        while ((n = Short.parseShort(reader.readLine())) != 0) {
            sum = 0;
            token = new StringTokenizer(reader.readLine());
            for (i = 0; i < n; i++) {
                wood[i] = Short.parseShort(token.nextToken());
                sum += wood[i];
            }
            // 从小到大排序
            Arrays.sort(wood, 0, n);

            // len表示木棍原始的长度,应该是大于等于最长的木棍(max),小于等于木棍长度总和(sum)
            for (len = wood[n - 1]; len < sum; len++) {
                // 长度必须能够被总和整除
                if (sum % len != 0)
                    continue;
                k = sum / len; // 一共需要组合出k根len长度的木棍
                if (mergeWood(n, len, k - 1, len, n)) {
                    System.out.println(len);
                    break;
                }
            }
            // 没有找到肯定是全部只有一根
            if (len == sum)
                System.out.println(len);
        }
    }

    // 判断从所有的wood中能够组装成长度为len的k根木棍,left表示正在组装的木棍的长度
    private static boolean mergeWood(int n, int len, int k, int left, int lastidx) {
        // 没有需要组装的木棍
        if (left == 0)
            return k == 0 || mergeWood(n, len, k - 1, len, n);

        // 从大到小进行选择,每根木棍都是应该是从大到小排序的,所以用lastidx表示上一根选中的位置,减少一些重复判断
        for (int i = lastidx - 1; i >= 0; i--) {
            // 选择一根没有被找到的并且有合适的长度的木棍
            int t = left - wood[i];
            if (t >= 0 && visit[i] != '1') {
                visit[i] = '1';
                // 假如剩下的也能组装完成,说明匹配成功
                if (mergeWood(n, len, k, t, i)) {
                    visit[i] = '0';
                    return true;
                }
                // 匹配失败,继续尝试下一根木棍
                visit[i] = '0';
                // 如果当前是left的第一根或最后一根,说明已经没办法继续处理了
                if (t == 0 || left == len)
                    return false;
            }
        }
        // 组装没有成功
        return false;
    }
}