package subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 * <p/>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        boolean[] checks = new boolean[S.length];
        subsets(0, S, checks, sets);
        return sets;
    }

    private void subsets(int idx, int[] S, boolean[] checks, List<List<Integer>> sets) {
        if (idx == S.length) {
            List<Integer> set = new ArrayList<Integer>();
            for (int i = 0; i < S.length; i++) {
                if (checks[i]) {
                    set.add(S[i]);
                }
            }
            sets.add(set);
            return;
        }
        checks[idx] = false;
        subsets(idx + 1, S, checks, sets);
        checks[idx] = true;
        subsets(idx + 1, S, checks, sets);
    }

    @Test
    public void test() {
        List<List<Integer>> subsets = subsets(new int[]{1, 3, 2, 4});
        System.out.println(subsets);
    }
}
