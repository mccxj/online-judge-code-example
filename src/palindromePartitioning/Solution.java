package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p/>
 * Return all possible palindrome partitioning of s.
 * <p/>
 * For example, given s = "aab",
 * Return
 * <p/>
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class Solution {
    private String str;
    private int len;
    private ArrayList<String> part;
    private ArrayList<List<String>> parts;

    public List<List<String>> partition(String s) {
        parts = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) {
            return parts;
        }

        this.str = s;
        this.len = s.length();
        this.part = new ArrayList<String>();
        findPalindrome(0);
        return parts;
    }

    private void findPalindrome(int pos) {
        if (pos == len) {
            parts.add(new ArrayList<String>(part));
        }

        for (int i = pos + 1; i <= len; i++) {
            String substr = str.substring(pos, i);
            if (isPalindrome(substr)) {
                part.add(substr);
                findPalindrome(i);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String substr) {
        final int strlen = substr.length();
        for (int i = 0; i < strlen / 2; i++) {
            if (substr.charAt(i) != substr.charAt(strlen - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
