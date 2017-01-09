import unittest


class Test0014(unittest.TestCase):
    def test_problem(self):
        dict = {1: 1}
        max_depth, num = 1, 1

        for i in range(2, 1000001):
            j = i
            stack = []
            while not dict.has_key(j):
                stack.append(j)
                if j % 2 == 0:
                    j = j / 2
                else:
                    j = 3 * j + 1
            depth = len(stack)
            for d in range(depth):
                dict[stack[d]] = dict[j] + depth - d
            if dict[i] > max_depth:
                max_depth = dict[i]
                num = i

        self.assertEqual(num, 837799)