import unittest
import code_helper


class Test0004(unittest.TestCase):
    def test_problem(self):
        s = -1
        for i in range(100, 1000):
            for j in range(i, 1000):
                p = i * j
                if p == code_helper.reverse_number(p) and p > s:
                    s = p

        self.assertEqual(s, 906609)