package validPalindrome;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p/>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p/>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * <p/>
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        int first = 0;
        int last = s.length() - 1;
        while (first <= last) {
            char f = 0, l = 0;
            boolean found = false;
            while (first <= last) {
                f = s.charAt(first);
                if (('A' <= f && f <= 'Z') || ('a' <= f && f <= 'z') || ('0' <= f && f <= '9')) {
                    found = true;
                    break;
                }
                first++;
            }

            if (found) {
                while (first <= last) {
                    l = s.charAt(last);
                    if (('A' <= l && l <= 'Z') || ('a' <= l && l <= 'z') || ('0' <= l && l <= '9')) {
                        break;
                    }
                    last--;
                }

                if (Character.toLowerCase(f) != Character.toLowerCase(l)) {
                    return false;
                }
            }
            first++;
            last--;
        }
        return true;
    }
}
