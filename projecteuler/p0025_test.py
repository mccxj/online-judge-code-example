import unittest
import code_helper


class Test0025(unittest.TestCase):
    def test_problem(self):
        # range_fibonacci return 1,2,3..., so the init index is 1.
        min_num, idx = 10**999, 1
        for fib in code_helper.range_fibonacci(2 * min_num):
            idx += 1
            if fib >= min_num:
                break
        self.assertEqual(idx, 4782)