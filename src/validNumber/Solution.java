package validNumber;

/**
 * Validate if a given string is numeric.
 * <p/>
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 */
public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        boolean preNum = false;
        boolean nextNum = false;
        boolean isE = false;
        int dot = 1;// at most one(before 'e' or after)
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ' ') {
                break;
            }
            if ('-' == c || '+' == c) {
                if (i > 0 && (s.charAt(i - 1) != ' ' && s.charAt(i - 1) != 'e')) {
                    return false;
                }
                if (i + 1 < s.length()) {
                    char cc = s.charAt(i + 1);
                    if (('0' > cc || cc > '9') && '.' != cc) {
                        return false;
                    }
                }
            } else if ('0' <= c && c <= '9') {
                if (isE) {
                    nextNum = true;
                } else {
                    preNum = true;
                }
            } else if ('.' == c) {
                if (isE || dot == 0) {
                    return false;
                }
                dot--;
            } else if ('e' == c) {
                if (isE) {
                    return false;
                }
                dot = 1;// reset '.'
                isE = true;
            } else {
                return false;
            }
            i++;
        }

        if (!preNum || (isE && !nextNum)) {
            return false;
        }

        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                return false;
            }
            i++;
        }
        return true;
    }
}