import unittest
import code_helper


class Test0012(unittest.TestCase):
    def test_problem(self):
        primes = list(code_helper.range_prime(10000))
        triangle_number = -1
        for n in range(7000, 20000):
            triangle_number = n * (n + 1) / 2
            divisors = 1
            s = triangle_number
            for prime in primes:
                if s < prime:
                    break
                if s % prime == 0:
                    time = 1
                    while s % prime == 0:
                        s /= prime
                        time += 1
                    divisors *= time
            if divisors > 500:
                break

        self.assertEqual(triangle_number, 76576500)