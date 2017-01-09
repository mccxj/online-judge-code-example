import unittest


class Test0016(unittest.TestCase):
    def test_problem(self):
        f = 2**1000
        sum = 0
        while f != 0:
            sum += f % 10
            f /= 10
        self.assertEqual(sum, 1366)