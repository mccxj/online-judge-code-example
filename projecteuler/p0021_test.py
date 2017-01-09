import unittest
import math


def sum_of_divisors(n):
    s, m = 1, int(math.sqrt(n))
    for i in range(2, m + 1):
        if n % i == 0:
            j = n / i
            s += i + j
    return s


class Test0021(unittest.TestCase):
    def test_problem(self):
        sum = 0
        for i in range(2, 10000):
            j = sum_of_divisors(i)
            if j > i and i == sum_of_divisors(j):
                sum += i + j
        self.assertEqual(sum, 31626)