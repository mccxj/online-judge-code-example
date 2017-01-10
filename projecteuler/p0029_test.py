import unittest


class Test0029(unittest.TestCase):
    def test_problem(self):
        dict = {}
        for a in range(2, 101):
            t = a
            for b in range(2, 101):
                t *= a
                dict[t] = 1
        self.assertEqual(len(dict), 9183)