import unittest


class Test0039(unittest.TestCase):
    def test_problem(self):
        m, num = 0, 0
        for p in range(12, 1001):
            total = 0
            for a in range(1, p / 3 + 1):
                for b in range(a + 1, (p - a) / 2 + 1):
                    c = p - a - b
                    if a * a + b * b == c * c:
                        total += 1
            if m < total:
                m = total
                num = p
        self.assertEqual(num, 840)