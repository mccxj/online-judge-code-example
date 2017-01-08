import unittest
import code_helper


class Test0002(unittest.TestCase):
    def test_problem(self):
        s = sum(
            filter(lambda x: x % 2 == 0, code_helper.range_fibonacci(4000000)))
        self.assertEqual(s, 4613732)