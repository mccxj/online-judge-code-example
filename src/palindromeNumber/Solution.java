package palindromeNumber;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * <p/>
 * click to show spoilers.
 * <p/>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * <p/>
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p/>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * <p/>
 * There is a more generic way of solving this problem.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = x;
        int rev = 0;
        while (tmp != 0) {
            int k = tmp % 10;
            rev = rev * 10 + k;
            tmp = tmp / 10;
        }
        return rev == x;
    }

    @Test
    public void test() {
        assertTrue(isPalindrome(2));
        assertTrue(isPalindrome(232));
        assertTrue(isPalindrome(2332));
        assertTrue(isPalindrome(123454321));
        assertTrue(!isPalindrome(12345421));
        assertTrue(isPalindrome(0));
        assertTrue(!isPalindrome(-101));
    }
}
