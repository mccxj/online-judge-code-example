package countingBits;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 * <p>
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
class Solution {
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        //n = 2^k + m, bits(n)=bits(m)+1
        int k = 1;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (k + i > num) {
                    return bits;
                }
                bits[k + i] = bits[i] + 1;
            }
            k *= 2;
        }
    }
}