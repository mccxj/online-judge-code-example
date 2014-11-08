package lengthOfLastWord;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim();
        int idx = s.lastIndexOf(' ');
        return s.length() - idx - 1;
    }
}
