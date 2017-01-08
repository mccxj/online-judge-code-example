import unittest


class Test0001(unittest.TestCase):
    def test_problem(self):
        s = sum(filter(lambda x: x % 3 == 0 or x % 5 == 0, range(1, 1000)))
        self.assertEqual(s, 233168)