package permutationSequence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * <p/>
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <p/>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * <p/>
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        while (--k > 0) {
            int p = n - 1;
            while (nums[p - 1] > nums[p]) {
                p--;
            }

            for (int i = p, j = n - 1; i < j; i++, j--) {
                int t = nums[j];
                nums[j] = nums[i];
                nums[i] = t;
            }

            for (int i = p; i < n; i++) {
                if (nums[i] > nums[p - 1]) {
                    int t = nums[p - 1];
                    nums[p - 1] = nums[i];
                    nums[i] = t;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
    
    @Test
    public void test(){
        assertEquals("123", getPermutation(3, 1));
        assertEquals("231", getPermutation(3, 4));
        assertEquals("321", getPermutation(3, 6));
        assertEquals("1432", getPermutation(4, 6));
        assertEquals("123586497", getPermutation(9, 200));
        assertEquals("987654321", getPermutation(9, 362880));
    }
}
