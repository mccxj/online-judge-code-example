import unittest


class Test0006(unittest.TestCase):
    def test_problem(self):
        n = 100
        sum_of_squares = n * (n + 1) * (2 * n + 1) / 6
        square_of_sum = (n * (n + 1) / 2) * (n * (n + 1) / 2)
        diff = square_of_sum - sum_of_squares
        self.assertEqual(diff, 25164150)