package twoSum;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] clone = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(clone);
        int i = 0, j = clone.length - 1;
        while (clone[i] + clone[j] != target) {
            if (clone[i] + clone[j] > target) {
                j--;
            } else if (clone[i] + clone[j] < target) {
                i++;
            }
        }

        int index1 = -1, index2 = -1;
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k] == clone[i]) {
                index1 = k;
            }
        }
        for (int k = 0; k < numbers.length; k++) {
            if (numbers[k] == clone[j] && index1 != k) {
                index2 = k;
            }
        }

        if (index1 < index2) {
            return new int[]{index1 + 1, index2 + 1};
        } else {
            return new int[]{index2 + 1, index1 + 1};
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        int[] res = s.twoSum(new int[]{0, 4, 3, 0}, 0);
        assertEquals(1, res[0]);
        assertEquals(4, res[1]);
    }
}