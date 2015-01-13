package longestPalindromicSubstring;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 */
public class Solution {
    private String maxString = "";

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            // find longest odd palindrome
            findPalindrome(chars, length, i, 0);
            // find longest even palindrome
            findPalindrome(chars, length, i, 1);
        }
        return maxString;
    }

    private void findPalindrome(char[] chars, int length, int i, int shift) {
        int left = i;
        int right = i + shift;
        while (left >= 0 && right < length && chars[left] == chars[right]) {
            left--;
            right++;
        }
        if (right - left - 1 > maxString.length()) {
            maxString = new String(chars, left + 1, right - left - 1);
        }
    }
}