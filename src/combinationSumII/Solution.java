package combinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * Each number in C may only be used once in the combination.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 */
public class Solution {
    private List<List<Integer>> combs;
    private int[] candidates;
    private List<Integer> comb;

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        this.combs = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0 || target <= 0) {
            return combs;
        }

        //first sort all the nums
        Arrays.sort(num);
        this.candidates = num;
        this.comb = new ArrayList<Integer>();

        generate(0, target);
        return combs;
    }

    private void generate(int start, int target) {
        if (target == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            if (c > target) {
                return;
            }

            if (i == start || c != candidates[i - 1]) {
                comb.add(c);
                generate(i + 1, target - c);
                comb.remove(comb.size() - 1);
            }
        }
    }
}
