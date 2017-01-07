package distinctSubsequences;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * <p/>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p/>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p/>
 * Return 3.
 */
public class Solution {
    public int numDistinct(String S, String T) {
        if (S == null || T == null || S.length() < T.length()) {
            return 0;
        }
        if (T.length() == 0) {
            return 1;
        }

        // nums[i][j] : first i of S, first j of T
        int[][] nums = new int[S.length()][T.length()];

        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                sum++;
            }
            nums[i][0] = sum;
        }
        for (int i = 1; i < T.length(); i++) {
            nums[0][i] = 0;
        }

        for (int i = 1; i < S.length(); i++) {
            for (int j = 1; j < T.length(); j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                } else {
                    nums[i][j] = nums[i - 1][j];
                }
            }
        }
        return nums[S.length() - 1][T.length() - 1];
    }

    @Test
    public void test() {
        assertEquals(3, numDistinct("rabbbit", "rabbit"));
        assertEquals(6, numDistinct("rabbbitt", "rabbit"));
        assertEquals(2, numDistinct("rabbbitt", "t"));
        assertEquals(0, numDistinct("rabbbitt", "rti"));
        assertEquals(2, numDistinct("rabbbitt", "rit"));
    }
}