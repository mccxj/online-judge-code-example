import unittest
import code_helper


class Test0037(unittest.TestCase):
    def test_problem(self):
        primes = list(code_helper.range_prime(1000000))
        s = 0

        def trim_right_prime(n):
            n /= 10
            while n != 0:
                if code_helper.binary_search(primes, n) == -1:
                    return False
                n /= 10
            return True

        def trim_left_prime(n):
            base = 10
            while base < n:
                base *= 10
            while base != 10:
                base /= 10
                n %= base
                if code_helper.binary_search(primes, n) == -1:
                    return False
            return True

        total = 0
        for prime in primes:
            #print prime
            if prime > 10 and trim_left_prime(prime) and trim_right_prime(
                    prime):
                total += prime
        self.assertEqual(total, 748317)