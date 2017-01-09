import unittest
import code_helper


class Test0010(unittest.TestCase):
    def test_problem(self):
        self.assertEqual(sum(code_helper.range_prime(2000000)), 142913828922)