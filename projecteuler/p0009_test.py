import unittest


def check_pythagorean_triplet():
    for a in range(1, 293):
        for b in range(a + 1, 500):
            c = 1000 - a - b
            if a * a + b * b == c * c:
                return a * b * c


class Test0009(unittest.TestCase):
    def test_problem(self):
        # c^2 > 2a^2 => a < 1000/(2+sqrt(2)) = 293
        # b + c = 1000 - a < 1000 => b < 500
        self.assertEqual(check_pythagorean_triplet(), 31875000)