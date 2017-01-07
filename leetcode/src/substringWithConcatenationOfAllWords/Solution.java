package substringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * <p/>
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * <p/>
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> poses = new ArrayList<Integer>();
        if (L == null || L.length == 0 || S == null || S.isEmpty()) {
            return poses;
        }

        Map<String, Integer> nums = new HashMap<String, Integer>();
        for (String l : L) {
            nums.put(l, nums.containsKey(l) ? nums.get(l) + 1 : 1);
        }

        int size = L[0].length();
        for (int i = 0; i + size * L.length <= S.length(); i++) {
            boolean found = true;
            if (nums.containsKey(S.substring(i, i + size))) {
                Map<String, Integer> currHist = new HashMap<String, Integer>();
                for (int j = 0; j < L.length; j++) {
                    String word = S.substring(i + j * size, i + (j + 1) * size);
                    if (!nums.containsKey(word)) {
                        found = false;
                        break;
                    }
                    int hit = currHist.containsKey(word) ? currHist.get(word) + 1 : 1;
                    if (nums.get(word) < hit) {
                        found = false;
                        break;
                    }
                    currHist.put(word, hit);
                }
                if (found) {
                    poses.add(i);
                }
            }
        }
        return poses;
    }
}