package sortColors;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * <p/>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p/>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 */
public class Solution {
    public void sortColors(int[] A) {
        int low = -1;
        while (low < A.length - 1 && A[low + 1] == 0) {
            low++;
        }
        int high = A.length;
        while (high > 0 && A[high - 1] == 2) {
            high--;
        }

        int start = low + 1;
        int tmp;
        while (start < high) {
            switch (A[start]) {
                case 0:
                    tmp = A[low + 1];
                    A[low + 1] = A[start];
                    A[start] = tmp;
                    while (low < A.length - 1 && A[low + 1] == 0) {
                        low++;
                    }
                    if (start <= low) {
                        start = low + 1;
                    }
                    break;
                case 1:
                    start++;
                    break;
                case 2:
                    tmp = A[high - 1];
                    A[high - 1] = A[start];
                    A[start] = tmp;
                    while (high > 0 && A[high - 1] == 2) {
                        high--;
                    }
                    break;
            }
        }
    }

    @Test
    public void test() {
        int[] A = {2, 1, 1, 1, 0, 0, 2, 1, 2, 1, 0};
        int[] B = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2};
        sortColors(A);
        assertArrayEquals(B, A);

        A = new int[]{};
        B = new int[]{};
        sortColors(A);
        assertArrayEquals(B, A);

        A = new int[]{1};
        B = new int[]{1};
        sortColors(A);
        assertArrayEquals(B, A);

        A = new int[]{2, 2, 2, 2, 2};
        B = new int[]{2, 2, 2, 2, 2};
        sortColors(A);
        assertArrayEquals(B, A);

        A = new int[]{2, 1, 0};
        B = new int[]{0, 1, 2};
        sortColors(A);
        assertArrayEquals(B, A);
    }
}
