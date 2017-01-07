package textJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * <p/>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * <p/>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p/>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p/>
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * <p/>
 * Return the formatted lines as:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> strs = new ArrayList<String>();
        if (words == null) {
            return strs;
        }
        if (L == 0) {
            boolean allEmpty = true;
            for (String w : words) {
                if (!w.equals("")) {
                    allEmpty = false;
                    break;
                }
            }
            if (allEmpty) {
                strs.add("");
            }
            return strs;
        }

        int start = 0;
        while (start < words.length) {
            int end = start;
            int len = 0;
            while (end < words.length && len + (end - start) + words[end].length() <= L) {
                len += words[end].length();
                end++;
            }

            StringBuilder sb = new StringBuilder();
            if (end == words.length) {
                // last line
                for (int i = start; i < end - 1; i++) {
                    sb.append(words[i]).append(' ');
                }
                sb.append(words[end - 1]);
                for (int i = 0; i + len + end - start - 1 < L; i++) {
                    sb.append(' ');
                }
            } else {
                int allSpace = L - len;
                // only one word.
                int left, space;
                if (end == start + 1) {
                    sb.append(words[start]);
                    for (int j = 0; j < allSpace; j++) {
                        sb.append(' ');
                    }
                } else {
                    left = allSpace % (end - start - 1);
                    space = (allSpace - left) / (end - start - 1);
                    sb.append(words[start]);
                    for (int i = start + 1; i < end; i++) {
                        if (i < left + start + 1) {
                            sb.append(' ');
                        }
                        for (int j = 0; j < space; j++) {
                            sb.append(' ');
                        }
                        sb.append(words[i]);
                    }
                }
            }
            strs.add(sb.toString());
            start = end;
        }
        return strs;
    }
}
