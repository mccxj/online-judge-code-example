import unittest
import code_helper


class Test0027(unittest.TestCase):
    def test_problem(self):
        # n^2+an+b, where |a|<1000|a|<1000 and |b|<=1000
        product, maximum = 0, 0
        # n=0 then b should be prime number.
        for b in code_helper.range_prime(1000):
            # n=1,then result is 1+a+b => 1+a+b>=2, then a>=1-b
            for a in range(1 - b, 1000):
                seq = 0
                # n=0,then result is b, must be a prime. so skip n=0
                for n in range(1, 1000):
                    if code_helper.is_prime(n * n + a * n + b):
                        seq += 1
                    else:
                        break
                if seq > maximum:
                    maximum = seq
                    product = a * b

        self.assertEqual(product, -59231)