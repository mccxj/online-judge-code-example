package uniqueBinarySearchTrees;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += nums[j] * nums[i - j - 1];
            }
            nums[i] = sum;
        }
        return nums[n];
    }

    @Test
    public void test() {
        assertEquals(1, numTrees(1));
        assertEquals(2, numTrees(2));
        assertEquals(5, numTrees(3));
        assertEquals(14, numTrees(4));
    }
}
