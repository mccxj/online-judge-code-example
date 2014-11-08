package mergeSortedArray;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p/>
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int[] c = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                c[k++] = A[i++];
            } else {
                c[k++] = B[j++];
            }
        }
        while (i < m) {
            c[k++] = A[i++];
        }
        while (j < n) {
            c[k++] = B[j++];
        }
        for (int t = 0; t < m + n; t++) {
            A[t] = c[t];
        }
    }
}
