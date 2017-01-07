package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 排列(http://poj.org/problem?id=1833)
 * <p/>
 * <p/>
 * 全排列相关,使用了字典序法
 */
public class Main1833 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(reader.readLine());
        while (m-- > 0) {
            StringTokenizer token = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(token.nextToken());
            int k = Integer.parseInt(token.nextToken());

            // 待处理数据
            token = new StringTokenizer(reader.readLine());
            int[] num = new int[n];
            for (int i = 0; i < n; i++)
                num[i] = Integer.parseInt(token.nextToken());

            // 查找k次
            while (k-- > 0) {
                // 从右到左,查找第一个比右边小的数
                int min = n - 1;
                for (int i = n - 2; i >= 0; i--) {
                    if (num[i] < num[i + 1]) {
                        min = i;
                        break;
                    }
                }

                // 没有找到,说明已经到了尽头,头尾对调
                if (min == n - 1) {
                    swapArr(num, 0, n - 1);
                    continue;
                }

                // 找到之后,从它后面的数中找到比它大的最小的数,采用两分查找
                int max = -1;
                int low = min + 1;
                int high = n - 1;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (num[mid] > num[min]) {
                        if (mid + 1 >= n || num[mid + 1] < num[min]) {
                            max = mid;
                            break;
                        }
                        low = mid + 1;
                    } else {
                        if (mid - 1 < 0 || num[mid - 1] > num[min]) {
                            max = mid - 1;
                            break;
                        }
                        high = mid + 1;
                    }
                }

                // 调换两者的位置
                swap(num, min, max);

                // 把后面的列表进行反转
                swapArr(num, min + 1, n - 1);
            }

            StringBuilder sb = new StringBuilder(n * 4);
            sb.append(num[0]);
            for (int i = 1; i < n; i++)
                sb.append(' ').append(num[i]);
            System.out.println(sb);
        }
    }

    // 把数组中a~b位置的数组进行反转
    public static void swapArr(int[] num, int a, int b) {
        int len = (b - a + 1) / 2;
        for (int i = 0; i < len; i++)
            swap(num, a + i, b - i);
    }

    public static void swap(int[] num, int a, int b) {
        int t = num[a];
        num[a] = num[b];
        num[b] = t;
    }
}