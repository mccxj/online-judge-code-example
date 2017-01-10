import unittest


class Test0030(unittest.TestCase):
    def test_problem(self):
        total = 0
        for n in range(2, 1000000):
            s, t = 0, n
            while t != 0:
                s += (t % 10)**5
                t /= 10
            if s == n:
                total += n
        self.assertEqual(total, 443839)