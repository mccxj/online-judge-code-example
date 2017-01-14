import unittest
import code_helper


class Test0035(unittest.TestCase):
    def test_problem(self):
        primes = list(code_helper.range_prime(1000000))
        total = 0

        def odd_digit(t):
            s = 0
            while t != 0:
                # if one digit mod 2 == 0, then is not a circular prime.
                if t % 2 == 0:
                    return 0
                t /= 10
                s += 1
            return s

        def is_circular_prime(prime, digit_len):
            base = 10**(digit_len - 1)
            for i in range(digit_len - 1):
                prime = prime % 10 * base + prime / 10
                if code_helper.binary_search(primes, prime) == -1:
                    return False
            return True

        for prime in primes:
            if prime < 10:
                total += 1
                continue
            digit_len = odd_digit(prime)
            if digit_len != 0 and is_circular_prime(prime, digit_len):
                # print prime
                total += 1
        self.assertEqual(total, 55)
