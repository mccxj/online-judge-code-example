package combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p/>
 * For example,
 * If n = 4 and k = 2, a solution is:
 * <p/>
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 */
public class Solution {
    private List<List<Integer>> combs;
    private int[] comb;
    private int k;
    private int n;

    public List<List<Integer>> combine(int n, int k) {
        this.combs = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return combs;
        }

        this.n = n;
        this.k = k;
        this.comb = new int[k];
        generate(1, 0);
        return combs;
    }

    private void generate(int start, int pos) {
        if (pos == k) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int c : comb) {
                tmp.add(c);
            }
            combs.add(tmp);
            return;
        }

        for (int i = start; i <= n; i++) {
            comb[pos] = i;
            generate(i + 1, pos + 1);
        }
    }
}
