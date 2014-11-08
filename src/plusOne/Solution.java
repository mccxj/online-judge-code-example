package plusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int[] newdigists = new int[digits.length];
        int plus = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            newdigists[i] = digits[i] + plus;
            if (newdigists[i] >= 10) {
                newdigists[i] -= 10;
                plus = 1;
            } else {
                plus = 0;
            }
        }

        if (plus == 0) {
            return newdigists;
        } else {
            int[] tmpdigists = new int[digits.length + 1];
            tmpdigists[0] = 1;
            System.arraycopy(newdigists, 0, tmpdigists, 1, digits.length);
            return tmpdigists;
        }
    }
}
