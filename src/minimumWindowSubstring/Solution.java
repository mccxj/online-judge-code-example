package minimumWindowSubstring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p/>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p/>
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * <p/>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    public String minWindow(String S, String T) {
        if (T == null || T.length() == 0) {
            return "";
        }

        Map<Character, Integer> maxPos = new HashMap<Character, Integer>();
        int[] poses = new int[T.length()];
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            int mp = -1;
            if (maxPos.containsKey(c)) {
                mp = maxPos.get(c);
            }
            int idx = S.indexOf(c, mp + 1);
            if (idx == -1) {
                return "";
            }
            maxPos.put(c, idx);
            poses[i] = idx;
        }
        if (poses.length == 1) {
            return T.toString();
        }

        // act as min heap.
        Arrays.sort(poses);
        int max = poses[poses.length - 1];

        String winStr = S.substring(poses[0], max + 1);
        while (true) {
            char c = S.charAt(poses[0]);
            int next = S.indexOf(c, maxPos.get(c) + 1);
            if (next == -1) {
                break;
            }
            maxPos.put(c, next);
            if (next > max) {
                max = next;
            }
            //top down, act as min heap.
            int i = 0;
            while (i < poses.length) {
                int j = i;
                int t = 2 * i + 1;
                if (t < poses.length) {
                    if (poses[t] < next) {
                        j = t;
                        if (t + 1 < poses.length && poses[t + 1] < poses[t]) {
                            j = t + 1;
                        }
                    } else if (t + 1 < poses.length && poses[t + 1] < next) {
                        j = t + 1;
                    }
                }
                if (j == i) {
                    break;
                } else {
                    poses[i] = poses[j];
                    i = j;
                }
            }
            poses[i] = next;

            if (max - poses[0] + 1 < winStr.length()) {
                winStr = S.substring(poses[0], max + 1);
            }
        }
        return winStr;
    }
}