package subsetsII;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * <p/>
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,2], a solution is:
 * <p/>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> sets = new ArrayList<List<Integer>>();
        if (num.length == 0) {
            return sets;
        }
        Arrays.sort(num);
        List<Integer> dists = new ArrayList<Integer>();
        List<Integer> max = new ArrayList<Integer>();
        int prev = num[0];
        int total = 1;
        dists.add(prev);
        for (int i = 1; i < num.length; i++) {
            if (prev != num[i]) {
                dists.add(num[i]);
                max.add(total);
                total = 1;
                prev = num[i];
            } else {
                total++;
            }
        }
        max.add(total);

        int[] checks = new int[max.size()];
        subsets(0, checks, dists, max, sets);
        return sets;
    }

    private void subsets(int idx, int[] checks, List<Integer> dists, List<Integer> max, List<List<Integer>> sets) {
        if (idx == dists.size()) {
            List<Integer> set = new ArrayList<Integer>();
            for (int i = 0; i < checks.length; i++) {
                for (int j = 0; j < checks[i]; j++) {
                    set.add(dists.get(i));
                }
            }
            sets.add(set);
            return;
        }
        for (int i = 0; i <= max.get(idx); i++) {
            checks[idx] = i;
            subsets(idx + 1, checks, dists, max, sets);
        }
    }

    @Test
    public void test() {
        List<List<Integer>> subsets = subsetsWithDup(new int[]{1, 2, 3, 2, 2});
        System.out.println(subsets);
    }
}
