import unittest


class Test0048(unittest.TestCase):
    def test_problem(self):
        s = sum(i**i for i in range(1, 1001)) % 10000000000
        self.assertEqual(str(s).zfill(10), '9110846700')