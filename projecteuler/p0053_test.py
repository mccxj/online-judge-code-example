import unittest


class Test0053(unittest.TestCase):
    def test_problem(self):
        fac, num = [1], 1000000
        for i in range(2, 101):
            fac.append(fac[-1] * i)
        total = 0
        for n in range(2, 101):
            for r in range(1, n):
                if fac[n - 1] / (fac[r - 1] * fac[n - r - 1]) > num:
                    total += 1
        self.assertEqual(total, 4075)