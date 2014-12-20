package nextPermutation;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p/>
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * <p/>
 * The replacement must be in-place, do not allocate extra memory.
 * <p/>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length == 0) {
            return;
        }

        //for right to left, find the last num that larger than the next one;
        int last = num.length - 1;
        while (last > 0 && num[last - 1] >= num[last]) {
            last--;
        }

        //resort nums after last
        for (int i = last, j = num.length - 1; i < j; i++, j--) {
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }

        if (last > 0) {
            //find the first num larger than prev, then exchange.
            int prev = last - 1;
            int tmp = num[prev];
            while (num[last] <= tmp) {
                last++;
            }
            num[prev] = num[last];
            num[last] = tmp;
        }
    }
}
