package removeElement;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <p/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int t = 0;
        for (int i = 0; i < len; i++) {
            if (elem != A[i]) {
                if (i != t) {
                    A[t] = A[i];
                }
                t++;
            }
        }
        return t;
    }
}
