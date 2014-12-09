package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p/>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * <p/>
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        if (num == null || num.length < 3) {
            return sums;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int a = num[i];
            for (int j = i + 1; j < num.length - 1; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                int b = num[j];
                int c = -(a + b);

                int low = j + 1;
                int high = num.length - 1;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (num[mid] == c) {
                        sums.add(Arrays.asList(a, b, c));
                        break;
                    } else if (num[mid] > c) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }

        return sums;
    }
}
