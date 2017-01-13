import unittest


class Test0023(unittest.TestCase):
    def test_problem(self):
        abundants = []
        divs = [1] * 28124
        divs[1] = 0
        for i in range(2, 28124):
            t = 2 * i
            while t < 28124:
                divs[t] += i
                t += i
            if divs[i] > i:
                abundants.append(i)
        nums = [0] * 28124
        for i in abundants:
            for j in abundants:
                if i + j <= 28123:
                    nums[i + j] = 1
        total = sum(i for i in range(1, 28124) if nums[i] == 0)
        self.assertEqual(total, 4179871)