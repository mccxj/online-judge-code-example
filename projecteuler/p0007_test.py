import unittest
import code_helper


class Test0007(unittest.TestCase):
    def test_problem(self):
        i, s = 0, 0
        for prime in code_helper.range_prime():
            i += 1
            if i == 10001:
                s = prime
                break

        self.assertEqual(s, 104743)