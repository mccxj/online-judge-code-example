package permutationsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p/>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 */
public class Solution {
    private List<List<Integer>> perms;
    private int[] num;
    private int size;
    private List<Integer> perm;
    private int[] used;

    public List<List<Integer>> permuteUnique(int[] num) {
        this.perms = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return perms;
        }

        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!nums.containsKey(n)) {
                nums.put(n, 1);
            } else {
                nums.put(n, nums.get(n) + 1);
            }
        }
        this.size = num.length;
        this.num = new int[nums.size()];
        this.used = new int[nums.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
            this.num[i] = entry.getKey();
            this.used[i] = entry.getValue();
            i++;
        }
        this.perm = new ArrayList<Integer>();
        generate(0);
        return perms;
    }

    private void generate(int pos) {
        if (pos == size) {
            List<Integer> np = new ArrayList<Integer>();
            for (int p : perm) {
                np.add(p);
            }
            perms.add(np);
        }

        for (int i = 0; i < num.length; i++) {
            if (used[i] > 0) {
                used[i]--;
                perm.add(num[i]);
                generate(pos + 1);
                perm.remove(perm.size() - 1);
                used[i]++;
            }
        }
    }
}
