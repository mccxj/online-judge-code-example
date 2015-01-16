package longestValidParentheses;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p/>
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * <p/>
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int len = s.length();
        // end with i th position
        int[] max = new int[len];
        // only one char, can not match
        max[0] = 0;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                max[i] = 0;
            } else if (c == ')') {
                char prev = s.charAt(i - 1);
                if (prev == '(') {
                    max[i] = 2;
                    // try to match more
                    if (i - 2 >= 0) {
                        max[i] += max[i - 2];
                    }
                } else if (prev == ')') {
                    int lastpos = i - 1 - max[i - 1];
                    // match fail
                    if (lastpos < 0 || s.charAt(lastpos) == ')') {
                        max[i] = 0;
                    } else {
                        max[i] = max[i - 1] + 2;
                        if (i - max[i] > 0) {
                            max[i] += max[i - max[i]];
                        }
                    }
                }
            }
        }

        int maxlen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (max[i] > maxlen) {
                maxlen = max[i];
            }
        }
        return maxlen;
    }
}