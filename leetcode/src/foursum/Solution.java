package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p/>
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * <p/>
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> sums = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4) {
            return sums;
        }

        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int a = num[i];
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                int b = num[j];
                for (int k = j + 1; k < num.length - 1; k++) {
                    if (k > j + 1 && num[k] == num[k - 1]) {
                        continue;
                    }
                    int c = num[k];
                    int d = target - (a + b + c);

                    int low = k + 1;
                    int high = num.length - 1;
                    while (low <= high) {
                        int mid = (low + high) >>> 1;
                        if (num[mid] == d) {
                            sums.add(Arrays.asList(a, b, c, d));
                            break;
                        } else if (num[mid] > d) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                }
            }
        }

        return sums;
    }
}
