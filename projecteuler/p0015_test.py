import unittest


class Test0015(unittest.TestCase):
    def test_problem(self):
        grid = [1] * 21
        for _ in range(20):
            for j in range(1, 21):
                grid[j] = grid[j - 1] + grid[j]
        self.assertEqual(grid[20], 137846528820)