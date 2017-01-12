import unittest


class Test0045(unittest.TestCase):
    def test_problem(self):
        tn, pn, hn = 286, 166, 144
        num = -1
        while True:
            t = tn * (tn + 1) / 2
            p = pn * (3 * pn - 1) / 2
            h = hn * (2 * hn - 1)
            if t == p and t == h:
                num = t
                break
            if t <= p:
                if t <= h:
                    tn += 1
                else:
                    hn += 1
            else:
                if p <= h:
                    pn += 1
                else:
                    hn += 1
        self.assertEqual(num, 1533776805)