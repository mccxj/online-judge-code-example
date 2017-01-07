package org.poj;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Ultra-QuickSort(http://poj.org/problem?id=2299)
 * 
 * <p>
 * 计算逆序对总数,可使用归并排序来计算<br/>
 * 注意的是,输入的数交换次数可能很多,需要用long
 */
public class Main2299 {
    private static long sum = 0;

    public static void main(String args[]) {
        Scanner cin = new Scanner(new BufferedInputStream(System.in));

        int n;
        while ((n = cin.nextInt()) != 0) {
            sum = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = cin.nextInt();

            mergeSort(arr, 0, n - 1);
            System.out.println(sum);
        }
    }

    private static int[] mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) >> 1;
        if (start == end)
            return new int[]{arr[start]};
        return merge(mergeSort(arr, start, mid), mergeSort(arr, mid + 1, end));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int curr = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[curr++] = a[i++];
            } else {
                sum += (a.length - i);
                c[curr++] = b[j++];
            }
        }
        while (i < a.length)
            c[curr++] = a[i++];
        while (j < b.length)
            c[curr++] = b[j++];
        return c;
    }
}