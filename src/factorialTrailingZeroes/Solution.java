package factorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p/>
 * Note: Your solution should be in logarithmic time complexity.
 * <p/>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution {
    /*
    只有2*5可以等于10(大数可以分解),2的数量明显要多，所以只需要算一共可以拆分多少个5.
    可以计算不大于n的数，是5,25,125...的倍数的个数总和
     */
    public int trailingZeroes(int n) {
        int total = 0;
        int base = 5;
        while (base <= n) {
            total += n / base;
            n = n / 5;
        }
        return total;
    }
}
