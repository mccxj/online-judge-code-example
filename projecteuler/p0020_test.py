import unittest
import math


class Test0020(unittest.TestCase):
    def test_problem(self):
        f = math.factorial(100)
        sum = 0
        while f != 0:
            sum += f % 10
            f /= 10
        self.assertEqual(sum, 648)