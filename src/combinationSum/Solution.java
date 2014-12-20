package combinationSum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p/>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p/>
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class Solution {
    private List<List<Integer>> combs;
    private int[] candidates;
    private List<Integer> comb;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.combs = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return combs;
        }

        //first sort all the nums
        Arrays.sort(candidates);
        this.candidates = candidates;
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

            comb.add(c);
            generate(i, target - c);
            comb.remove(comb.size() - 1);
        }
    }

    @Test
    public void test() {
        combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
