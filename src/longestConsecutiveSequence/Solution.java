package longestConsecutiveSequence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p/>
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * <p/>
 * Your algorithm should run in O(n) complexity.
 */
public class Solution {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
        for (int n : num) {
            nums.put(n, true);
        }

        int max = 0;
        int size;
        Iterator<Map.Entry<Integer, Boolean>> it = nums.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Boolean> next = it.next();
            if (next.getValue()) {
                size = 1;
                int curr = next.getKey();

                int tmp = curr + 1;
                if (curr < Integer.MAX_VALUE) {
                    while (tmp <= Integer.MAX_VALUE && nums.containsKey(tmp)) {
                        nums.put(tmp, false);
                        size++;
                        tmp++;
                    }
                }

                tmp = curr - 1;
                if (curr > Integer.MIN_VALUE) {
                    while (tmp >= Integer.MIN_VALUE && nums.containsKey(tmp)) {
                        nums.put(tmp, false);
                        size++;
                        tmp--;
                    }
                }

                if (size > max) {
                    max = size;
                }
            }
        }

        return max;
    }
}