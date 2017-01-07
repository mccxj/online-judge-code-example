package anagrams;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * <p/>
 * Note: All inputs will be in lower-case
 */
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> groups = new ArrayList<String>();
        Map<String, Integer> x = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sortStr = new String(cs);

            if (x.containsKey(sortStr)) {
                int idx = x.get(sortStr);
                if (idx != -1) {
                    groups.add(strs[idx]);
                    x.put(sortStr, -1);
                }
                groups.add(str);
            } else {
                x.put(sortStr, i);
            }
        }

        return groups;
    }

    @Test
    public void test() {
        List<String> groups = anagrams(new String[]{"tea", "and", "ate", "eat", "den", "ned"});
        assertEquals(5, groups.size());
    }
}
