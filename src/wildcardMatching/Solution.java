package wildcardMatching;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p/>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * <p/>
 * The matching should cover the entire input string (not partial).
 * <p/>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p/>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class Solution {
    private String s;
    private String p;
    private Set<String> matches;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.matches = new HashSet<String>();
        return isMatch(0, 0);
    }

    private boolean isMatch(int spos, int ppos) {
        String key = spos + "=" + ppos;
        if (matches.contains(key)) {
            return false;
        }

        if (spos >= s.length()) {
            // all left is '*'
            while (ppos < p.length()) {
                if ('*' != p.charAt(ppos)) {
                    return false;
                }
                ppos++;
            }
            return true;
        }
        // could not math all s.
        if (ppos >= p.length()) {
            return false;
        }

        char pc = p.charAt(ppos);
        int nppos = ppos;
        if (pc == '*' || pc == '?') {
            int ask = 0;
            while (nppos < p.length()) {
                pc = p.charAt(nppos);
                if (pc == '?') {
                    ask++;
                    nppos++;
                } else if (pc == '*') {
                    nppos++;
                } else {
                    break;
                }
            }

            // only '?'
            if (nppos == ppos + ask) {
                if (spos + ask <= s.length()) {
                    return isMatch(spos + ask, nppos);
                }
            } else {
                // skip '?'
                spos += ask;
                if (spos <= s.length()) {
                    ppos = nppos;
                    while (nppos < p.length()) {
                        pc = p.charAt(nppos);
                        if (pc != '?' && pc != '*') {
                            nppos++;
                        } else {
                            break;
                        }
                    }
                    // has *, should match all sequence.
                    String str = p.substring(ppos, nppos);
                    if (str.isEmpty()) {
                        return true;
                    } else {
                        int nspos = s.indexOf(str, spos);
                        while (nspos != -1) {
                            if (isMatch(nspos + nppos - ppos, nppos)) {
                                return true;
                            }
                            nspos = s.indexOf(str, nspos + 1);
                        }
                    }
                }
            }
        } else {
            while (nppos < p.length()) {
                pc = p.charAt(nppos);
                if (pc != '?' && pc != '*') {
                    nppos++;
                } else {
                    break;
                }
            }
            // not ? or *, should match all sequence.
            String str = p.substring(ppos, nppos);
            if (spos + nppos - ppos <= s.length()
                    && str.equals(s.substring(spos, spos + nppos - ppos))) {
                return isMatch(spos + nppos - ppos, nppos);
            }
        }
        matches.add(key);
        return false;
    }
}