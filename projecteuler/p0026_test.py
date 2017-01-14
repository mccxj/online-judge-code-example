import unittest


class Test0026(unittest.TestCase):
    def test_problem(self):
        longest, num = 0, 1

        def find_cycle(n, mods):
            m = len(mods)
            for j in range(0, m):
                if n == mods[j]:
                    return m - j
            return 0

        for i in range(2, 1000):
            n, mods = 10, []
            while n != 0:
                cycle = find_cycle(n, mods)
                if cycle != 0:
                    if cycle > longest:
                        longest, num = cycle, i
                    break
                mods.append(n)
                #mul by 10 or div by i, then mul by 10
                n = n*10 if n < i else n % i * 10
        self.assertEqual(num, 983)
