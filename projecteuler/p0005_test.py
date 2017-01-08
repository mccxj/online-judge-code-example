import unittest


class Test0005(unittest.TestCase):
    def test_problem(self):
        s = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19
        s *= 8  # for 12,16,20
        s *= 3  # for 18

        self.assertEqual(s, 232792560)