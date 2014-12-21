package wordBreakII;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 * <p/>
 * Return all such possible sentences.
 * <p/>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p/>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Solution {
    private List<Integer> matches;
    private String s;
    private ArrayList<String> words;
    private Set<String> dict;

    public List<String> wordBreak(String s, Set<String> dict) {
        this.words = new ArrayList<String>();
        this.dict = dict;
        if (s == null || s.isEmpty()) {
            return words;
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
        if (last != s.length()) {
            return words;
        }

        this.matches = matches;
        this.s = s;
        wordBreak(0, new StringBuilder());
        return words;
    }

    private void wordBreak(int idx, StringBuilder sb) {
        if (idx == matches.size() - 1) {
            if (sb.length() > 0) {
                words.add(sb.substring(0, sb.length() - 1));
                return;
            }
        }

        for (int i = idx + 1; i < matches.size(); i++) {
            int spos = matches.get(idx);
            int epos = matches.get(i);
            String sub = s.substring(spos, epos);
            if (dict.contains(sub)) {
                int oldLen = sb.length();
                sb.append(sub).append(' ');
                wordBreak(i, sb);
                sb.setLength(oldLen);
            }

        }
    }

    @Test
    public void test() {
        Set<String> dicts = new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
        List<String> words = wordBreak("catsanddog", dicts);
        assertEquals(2, words.size());
        words = wordBreak("catsdogand", dicts);
        assertEquals(1, words.size());
    }
}