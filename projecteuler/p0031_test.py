import unittest


def ways(total, coins, curr):
    # left 1 pence.
    if curr == 7:
        return 1
    # no coins left.
    if total == 0:
        return 1
    total_way, max_num = 0, total / coins[curr]
    for i in range(0, max_num + 1):
        total_way += ways(total - coins[curr] * i, coins, curr + 1)
    return total_way


class Test0031(unittest.TestCase):
    def test_problem(self):
        coins = [200, 100, 50, 20, 10, 5, 2, 1]
        self.assertEqual(ways(200, coins, 0), 73682)