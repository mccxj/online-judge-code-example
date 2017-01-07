package wordLadder;

import java.util.*;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * <p/>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * <p/>
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p/>
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)) {
            return 2;
        }

        HashMap<String, Integer> levels = new HashMap<String, Integer>();
        Queue<String> starts = new ArrayDeque<String>();
        starts.add(start);
        levels.put(start, 1);
        dict.add(end);

        while (!starts.isEmpty()) {
            if (levels.containsKey(end)) {
                return levels.get(end);
            }

            String s = starts.poll();
            List<String> words = ableToChange(s, dict);
            int level = levels.get(s) + 1;
            for (String word : words) {
                levels.put(word, level);
                dict.remove(word);
                starts.add(word);
            }
        }
        return 0;
    }

    private List<String> ableToChange(String str, Set<String> dict) {
        List<String> words = new ArrayList<String>();
        final int len = str.length();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < len; i++) {
            char a = sb.charAt(i);
            for (int j = 0; j < 26; j++) {
                char b = (char) ('a' + j);
                if (a != b) {
                    sb.setCharAt(i, b);
                    final String ns = sb.toString();
                    if (dict.contains(ns)) {
                        words.add(ns);
                    }
                }
            }
            sb.setCharAt(i, a);
        }
        return words;
    }
}
