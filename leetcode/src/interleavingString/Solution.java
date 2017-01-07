package interleavingString;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p/>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p/>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[] m = new boolean[s1.length() + 1];
        m[0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            m[i] = m[i - 1] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }

        for (int i = 1; i <= s2.length(); i++) {
            m[0] = m[0] && s3.charAt(i - 1) == s2.charAt(i - 1);
            for (int j = 1; j <= s1.length(); j++) {
                m[j] = (m[j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1))
                        || (m[j] && s2.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return m[s1.length()];
    }

    @Test
    public void test() {
        assertEquals(true, isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertEquals(false, isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertEquals(true, isInterleave("", "c", "c"));
        assertEquals(true, isInterleave("c", "", "c"));
        assertEquals(true, isInterleave("c", "a", "ca"));
        assertEquals(true, isInterleave("c", "a", "ac"));
        assertEquals(true, isInterleave("", "", ""));
        assertEquals(false, isInterleave("ace", "bc", "abccd"));
    }
}
