import unittest


class Test0028(unittest.TestCase):
    def test_problem(self):
        # assum 0 < n <= rows/2, last num is (2n+1)*(2n+1)
        # when n > 0 then four num is 
        #   right-buttom: (2n-1)*(2n-1)+2n
        #   left-buttm: (2n-1)*(2n-1)+4n
        #   left-top: (2n-1)*(2n-1)+6n
        #   right-top: (2n-1)*(2n-1)+8n = (2n+1)*(2n+1)
        rows = 1001
        s = 1 + sum(4 * (2 * n - 1) * (2 * n - 1) + 20 * n
                    for n in range(1, rows / 2 + 1))
        self.assertEqual(s, 669171001)