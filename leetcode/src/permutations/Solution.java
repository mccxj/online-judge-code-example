package permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * <p/>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Solution {
    private List<List<Integer>> perms;
    private int[] num;
    private int size;
    private List<Integer> perm;
    private boolean[] used;

    public List<List<Integer>> permute(int[] num) {
        this.perms = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return perms;
        }

        this.num = num;
        this.size = num.length;
        this.used = new boolean[size];
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

        for (int i = 0; i < size; i++) {
            if (!used[i]) {
                used[i] = true;
                perm.add(num[i]);
                generate(pos + 1);
                perm.remove(perm.size() - 1);
                used[i] = false;
            }
        }
    }
}
