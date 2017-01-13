import unittest


class Test0036(unittest.TestCase):
    def test_problem(self):
        total = 0
        for i in range(1, 1000000):
            s = str(i)
            if s == s[::-1]:
                b = bin(i)[2:]
                if b == b[::-1]:
                    total += i
        self.assertEqual(total, 872187)