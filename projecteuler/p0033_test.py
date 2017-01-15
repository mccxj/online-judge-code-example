import unittest
import code_helper

class Test0033(unittest.TestCase):
    def test_problem(self):
        u,v = 1,1
        for a in range(1, 10):
            for b in range(1, 10):
                if a != b:
                    for c in range(1, 10):
                        if (a * 10 + b) * c == (b * 10 + c) * a:
                            u *= a * 10 + b
                            v *= b * 10 + c
        g = code_helper.gcd(u, v)
        self.assertEqual(v/g, 100)