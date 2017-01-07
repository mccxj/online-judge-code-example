package wordBreak;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p/>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p/>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        List<Integer> matches = new ArrayList<Integer>();
        matches.add(0);

        for (int i = 1; i <= s.length(); i++) {
            boolean found = false;
            for (int match : matches) {
                if (dict.contains(s.substring(match, i))) {
                    found = true;
                    break;
                }
            }

            if (found) {
                matches.add(i);
            }
        }

        int last = matches.get(matches.size() - 1);
        return last == s.length();
    }
}