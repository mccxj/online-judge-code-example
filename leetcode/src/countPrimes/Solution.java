package countPrimes;

import java.util.ArrayList;
import java.util.List;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        } else if (n == 3) {
            return 1;
        }
        List<Integer> primes = new ArrayList<Integer>(1024);
        primes.add(2);
        for (int i = 3; i > 0 && i < n; i += 2) {
            if (isPrime(i, primes)) {
                primes.add(i);
            }
        }
        return primes.size();
    }

    private boolean isPrime(int num, List<Integer> primes) {
        int max = (int) Math.sqrt(num);
        for (int prime : primes) {
            if (max < prime) {
                break;
            }
            if (num % prime == 0) {
                return false;
            }
        }
        return true;
    }
}