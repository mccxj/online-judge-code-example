import unittest
import code_helper
import math


class Test0046(unittest.TestCase):
    def test_problem(self):
        nums = [0] * 50000
        for prime in code_helper.range_prime(100000):
            if prime != 2:
                m = (prime - 1) / 2
                nums[m - 1] = 1
                for i in range(1, int(math.sqrt(50000 - m)) + 1):
                    t = m + i * i - 1
                    if t < 50000:
                        nums[t] = 1
        f = -1
        for i in range(0, 50000):
            if nums[i] == 0:
                f = 2 * (i + 1) + 1
                break
        self.assertEqual(f, 5777)