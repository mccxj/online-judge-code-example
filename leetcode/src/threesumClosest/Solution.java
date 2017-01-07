package threesumClosest;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p/>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p/>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int t = target;
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
                int c = target - (a + b);

                int low = j + 1;
                int high = num.length - 1;
                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    if (num[mid] == c) {
                        return target;
                    } else if (num[mid] > c) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (low >= j + 1 && low <= num.length - 1) {
                    if (min > Math.abs(a + b + num[low] - target)) {
                        t = a + b + num[low];
                        min = Math.abs(t - target);
                    }
                }
                if (high >= j + 1 && high <= num.length - 1) {
                    if (min > Math.abs(a + b + num[high] - target)) {
                        t = a + b + num[high];
                        min = Math.abs(t - target);
                    }
                }
            }
        }

        return t;
    }
}
