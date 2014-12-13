package generateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p/>
 * For example, given n = 3, a solution set is:
 * <p/>
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    private List<String> combs;
    private char[] comb;
    private int n;

    public List<String> generateParenthesis(int n) {
        combs = new ArrayList<String>();
        if (n <= 0) {
            return combs;
        }

        this.n = n;
        comb = new char[n * 2];
        //generate the p1 pos, left p2 '(', left p3 ')'
        generate(0, n, n);
        return combs;
    }

    private void generate(int pos, int left, int right) {
        if (pos == 2 * n) {
            combs.add(new String(comb));
            return;
        }

        if (left > 0) {
            comb[pos] = '(';
            generate(pos + 1, left - 1, right);
        }
        if (left != right && right > 0) {
            comb[pos] = ')';
            generate(pos + 1, left, right - 1);
        }
    }
}
