import unittest
import code_helper


def largest_prime_factor(n):
    for prime in code_helper.range_prime(10000):
        while n % prime == 0:
            n /= prime
        if n == 1:
            return prime
    return n


class Test0003(unittest.TestCase):
    def test_problem(self):
        self.assertEqual(largest_prime_factor(600851475143), 6857)