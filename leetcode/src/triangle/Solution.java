package triangle;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p/>
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p/>
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] sum = new int[triangle.size()];
        sum[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int prev = Integer.MAX_VALUE;
            for (int j = 0; j < row.size() - 1; j++) {
                int tmp = Math.min(sum[j], prev) + row.get(j);
                prev = sum[j];
                sum[j] = tmp;

            }
            sum[row.size() - 1] = prev + row.get(row.size() - 1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            if (sum[i] < min) {
                min = sum[i];
            }
        }
        return min;
    }

    @Test
    public void test() {
        List<Integer> r1 = Arrays.asList(2);
        List<Integer> r2 = Arrays.asList(3, 4);
        List<Integer> r3 = Arrays.asList(6, 5, 7);
        List<Integer> r4 = Arrays.asList(4, 1, 8, 3);
        assertEquals(11, minimumTotal(Arrays.asList(r1, r2, r3, r4)));
        assertEquals(2, minimumTotal(Arrays.asList(r1)));
        assertEquals(5, minimumTotal(Arrays.asList(r1, r2)));
    }
}
