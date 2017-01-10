import unittest
import math


class Test0024(unittest.TestCase):
    def test_problem(self):
        distance, s = 999999, ''
        choose = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        # for 0 + other 9 number, total 9! = 362880
        for i in range(9, -1, -1):
            fac = math.factorial(i)
            n = distance / fac
            s += str(choose[n])
            del choose[n]
            distance = distance % fac
        self.assertEqual(s, '2783915460')