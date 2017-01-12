import unittest


class Test0034(unittest.TestCase):
    def test_problem(self):
        # let x has k digits, then 10^(k-1) <= x < 10^k, and k1! <= x <= k9!.
        # 10^(k-1) <= k9! = 362880k => k <= 7
        fac = [1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880]
        result = 0
        for k in range(2, 8):
            min_num = 10**(k - 1)
            for x in range(min_num, 10 * min_num):
                s, t = 0, x
                while t != 0:
                    s += fac[t % 10]
                    t /= 10
                if s == x:
                    result += x
        self.assertEqual(result, 40730)